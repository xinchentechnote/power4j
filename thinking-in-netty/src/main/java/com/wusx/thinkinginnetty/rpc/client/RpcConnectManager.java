package com.wusx.thinkinginnetty.rpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

/**
 * @Description 客户端连接管理器.
 * @Author:ShangxiuWu
 * @Date: 21:20 2020/6/21.
 * @Modified By:
 */
@Slf4j
public class RpcConnectManager {

  private static volatile RpcConnectManager rpcConnectManager = new RpcConnectManager();
  /** 等待可用连接超时秒数.*/
  private long connectTimeoutSeconds = 6;

  private volatile boolean isRunning = true;

  private volatile AtomicInteger handlerIndex = new AtomicInteger();

  private RpcConnectManager() {
  }

  public static RpcConnectManager getInstance() {
    return rpcConnectManager;
  }

  /** 一个连接地址，对应一个实际的业务处理器（client）.*/
  private Map<InetSocketAddress, RpcClientHandler> clientHandlerMap = new ConcurrentHashMap<>();
  /** 所有连接成功的地址所对应的业务处理器列表.*/
  private CopyOnWriteArrayList<RpcClientHandler> clientHandlerList = new CopyOnWriteArrayList<>();
  /** 异步发起连接的线程池.*/
  private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
      16,
      16,
      60,
      TimeUnit.SECONDS,
      new ArrayBlockingQueue<>(1024 * 1024)
  );

  private EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

  private ReentrantLock connectedLock = new ReentrantLock();

  private Condition connectedCondition = connectedLock.newCondition();

  //1、异步创建连接，使用线程池异步真正发起连接，失败监听和成功监听
  //2、对于连接进来的资源做缓存updateConnectedServer

  /**
   *@Description .
   *@params serverAddress多个地址由逗号分隔 127.0.0.1:9999
   *@return
   *@Author wusx
   *@Date 10:37 2020/6/25
   *@Modified
   */
  public void connect(final String serverAddress) {
    List<String> addressList = Arrays.asList(serverAddress.split(","));
    updateConnectedServer(addressList);
  }


  public void updateConnectedServer(List<String> addressList) {
    if (CollectionUtils.isEmpty(addressList)) {
      log.error("no available server address!");
      //清空缓存
      clearConnected();
    } else {
      //解析连接地址
      Set<InetSocketAddress> addressSet = new HashSet<>();
      for (int i = 0; i < addressList.size(); i++) {
        String[] hostAndPort = addressList.get(i).split(":");
        String host = hostAndPort[0];
        int port = Integer.parseInt(hostAndPort[1]);
        final InetSocketAddress remotePeer = new InetSocketAddress(host, port);
        addressSet.add(remotePeer);
      }
      //2、调用建立连接方法，发起远程连接操作
      for (InetSocketAddress address : addressSet) {
        if (!clientHandlerMap.keySet().contains(address)) {
          connectAsync(address);
        }
      }
      //3、如果addressList列表不存在的链接地址，需要从缓存中进行移除
      for (int i = 0; i < clientHandlerList.size(); i++) {
        RpcClientHandler rpcClientHandler = clientHandlerList.get(i);
        SocketAddress remotePeer = rpcClientHandler.getRemotePeer();
        if (!addressSet.contains(remotePeer)) {
          log.info("remove invalid server node :{}", remotePeer);
          RpcClientHandler handler = clientHandlerMap.get(remotePeer);
          if (null != handler) {
            handler.close();
            clientHandlerMap.remove(remotePeer);
          }
          clientHandlerList.remove(rpcClientHandler);
        }
      }
    }
  }

  /**
   *@Description 异步发起连接.
   *@Author wusx
   *@Date 11:48 2020/6/25
   *@Modified
   */
  private void connectAsync(InetSocketAddress address) {
    threadPoolExecutor.submit(new Runnable() {
      @Override
      public void run() {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
            .channel(NioSocketChannel.class)
            .option(ChannelOption.TCP_NODELAY, true)
            .handler(new RpcClientInitializer());
        connect(bootstrap, address);
      }


    });
  }

  private void connect(Bootstrap bootstrap, InetSocketAddress address) {
    //1、真正发起连接
    ChannelFuture channelFuture = bootstrap.connect(address);
    //2、连接失败，监听清楚资源后发起重连操作
    channelFuture.channel().closeFuture().addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture future) throws Exception {
        log.info("channelFuture.channel close operationComplete,remote peer {}", address);
        future.channel().eventLoop().schedule(new Runnable() {
          @Override
          public void run() {
            log.warn("connect failed,to reconnect...");
            //为什么要清空？
            clearConnected();
            connect(bootstrap, address);
          }
        }, 3, TimeUnit.SECONDS);
      }
    });
    //3、连接成功的时候添加监听，把新连接加入缓存
    channelFuture.addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture future) throws Exception {
        if (future.isSuccess()) {
          log.info("successfully connect to {}", address);
          RpcClientHandler rpcClientHandler = future.channel().pipeline()
              .get(RpcClientHandler.class);
          addHandler(address, rpcClientHandler);
        }
      }
    });
  }

  /**
   *@Description 添加rpcClientHandler到指定的缓存中.
   *@params
   *@return
   *@Author wusx
   *@Date 11:33 2020/6/25
   *@Modified
   */
  private void addHandler(InetSocketAddress socketAddress, RpcClientHandler rpcClientHandler) {
    clientHandlerList.add(rpcClientHandler);
    clientHandlerMap.put(socketAddress, rpcClientHandler);
    //唤醒可用的业务执行器signalAvailableHandler
    signalAvailableHandler();
  }

  /**
   *@Description 唤醒另外一端的线程，告知有新连接可用.
   *@params
   *@return
   *@Author wusx
   *@Date 11:39 2020/6/25
   *@Modified
   */
  private void signalAvailableHandler() {
    connectedLock.lock();
    try {
      connectedCondition.signalAll();
    } finally {
      connectedLock.unlock();
    }

  }

  /**
   *@Description 连接失败.及时释放资源，清空缓存
   *@params
   *@return
   *@Author wusx
   *@Date 11:14 2020/6/25
   *@Modified
   */
  private void clearConnected() {
    for (final RpcClientHandler rpcClientHandler : clientHandlerList) {
      //通过RPCClientHandler获取地址remotePeer
      SocketAddress remotePeer = rpcClientHandler.getRemotePeer();
      RpcClientHandler handler = clientHandlerMap.get(remotePeer);
      if (null != handler) {
        handler.close();
        clientHandlerMap.remove(remotePeer);
      }
    }
    clientHandlerList.clear();
  }

  private boolean waitingForAvailableHandler() throws InterruptedException {
    connectedLock.lock();
    try {
      return connectedCondition.await(this.connectTimeoutSeconds, TimeUnit.SECONDS);
    } finally {
      connectedLock.unlock();
    }
  }


  /**
   *@Description 选择一个实际的业务处理器.
   *@params
   *@return
   *@Author wusx
   *@Date 11:50 2020/6/25
   *@Modified
   */
  public RpcClientHandler chooseHandler() {
    CopyOnWriteArrayList<RpcClientHandler> handlers = (CopyOnWriteArrayList<RpcClientHandler>) this.clientHandlerList
        .clone();
    int size = handlers.size();
    while (isRunning && size <= 0) {
      try {
        boolean available = waitingForAvailableHandler();
        if (available) {
          handlers = (CopyOnWriteArrayList<RpcClientHandler>) this.clientHandlerList.clone();
          size = handlers.size();
        }
      } catch (InterruptedException e) {
        log.error("waiting for available node is interrupted.");
        throw new RuntimeException("no connect any server.", e);
      }
    }
    //通过取模获取可用的业务处理器
    if (isRunning && size > 0) {
      int index = (handlerIndex.getAndAdd(1) + size) % size;
      return handlers.get(index);
    }
    return null;
  }

  /**
   *@Description 停止.
   *@params
   *@return
   *@Author wusx
   *@Date 12:17 2020/6/25
   *@Modified
   */
  public void stop() {
    isRunning = false;
    for (int i = 0; i < clientHandlerList.size(); i++) {
      RpcClientHandler rpcClientHandler = clientHandlerList.get(i);
      rpcClientHandler.close();
    }
    //调用一下唤醒操作
    signalAvailableHandler();
    //关闭线程池
    threadPoolExecutor.shutdown();
    eventLoopGroup.shutdownGracefully();
  }

  /**
   *@Description 发起重连.
   *@params
   *@return
   *@Author wusx
   *@Date 12:19 2020/6/25
   *@Modified
   */
  public void reconnect(final RpcClientHandler rpcClientHandler,
      final SocketAddress socketAddress) {
    if (null != rpcClientHandler) {
      rpcClientHandler.close();
      clientHandlerList.remove(rpcClientHandler);
      clientHandlerMap.remove(socketAddress);
    }
    connectAsync((InetSocketAddress) socketAddress);
  }

}
