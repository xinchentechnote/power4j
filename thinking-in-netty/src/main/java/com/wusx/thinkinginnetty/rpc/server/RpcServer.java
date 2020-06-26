package com.wusx.thinkinginnetty.rpc.server;

import com.wusx.thinkinginnetty.rpc.codec.RpcDecoder;
import com.wusx.thinkinginnetty.rpc.codec.RpcEncoder;
import com.wusx.thinkinginnetty.rpc.codec.RpcRequest;
import com.wusx.thinkinginnetty.rpc.codec.RpcResponse;
import com.wusx.thinkinginnetty.rpc.config.provider.ProviderConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:14 2020/6/21.
 * @Modified By:
 */
@Slf4j
public class RpcServer {

  private String serverAddress;
  private EventLoopGroup bossGroup = new NioEventLoopGroup();
  private EventLoopGroup workerGroup = new NioEventLoopGroup();

  private volatile Map<String, Object> handlerMap = new HashMap<>();

  public RpcServer(String serverAddress) throws InterruptedException {
    this.serverAddress = serverAddress;
    start();
  }

  public void start() throws InterruptedException {
    ServerBootstrap bootstrap = new ServerBootstrap();
    bootstrap.group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .handler(new LoggingHandler(LogLevel.DEBUG))
        .option(ChannelOption.SO_BACKLOG, 1024)
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel ch) throws Exception {
            ChannelPipeline pipeline = ch.pipeline();
            pipeline.addLast(new RpcEncoder(RpcResponse.class));
            pipeline.addLast(new LengthFieldBasedFrameDecoder(65535, 0, 4, 0, 0));
            pipeline.addLast(new RpcDecoder(RpcRequest.class));
            pipeline.addLast(new RpcServerHandler(handlerMap));
          }
        });
    String[] hostAndPort = serverAddress.split(":");
    String host = hostAndPort[0];
    int port = Integer.parseInt(hostAndPort[1]);
    ChannelFuture channelFuture = bootstrap.bind(host, port).sync();
    channelFuture.addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture future) throws Exception {
        if (future.isSuccess()) {
          log.info("server success bind to :{}", serverAddress);
        } else {
          log.info("server fail bind to :{}", serverAddress);
          throw new Exception("server start fail. cause :{}", future.cause());
        }
      }
    });
    try {
      channelFuture.await(5, TimeUnit.SECONDS);
      if (channelFuture.isSuccess()) {
        log.info("start rapid rpc  success");
      }
    } catch (InterruptedException e) {
      log.error("start rapid rpc  occur Interrupted. ex:{}", e);
    }
  }

  public void registerProcessor(ProviderConfig providerConfig) {
    //key:接口全限名
    //value:接口下的具体实现类的实例对象
    handlerMap.put(providerConfig.getInterfaceClass(), providerConfig.getRef());
  }

  public void close() {
    bossGroup.shutdownGracefully();
    workerGroup.shutdownGracefully();
  }

}
