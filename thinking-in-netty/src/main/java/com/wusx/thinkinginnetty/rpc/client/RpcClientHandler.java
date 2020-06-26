package com.wusx.thinkinginnetty.rpc.client;

import com.wusx.thinkinginnetty.rpc.codec.RpcRequest;
import com.wusx.thinkinginnetty.rpc.codec.RpcResponse;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:20 2020/6/21.
 * @Modified By:
 */
public class RpcClientHandler extends SimpleChannelInboundHandler<RpcResponse> {

  private Channel channel;

  private SocketAddress remotePeer;

  private Map<String, RpcFuture> pendingRpcTable = new ConcurrentHashMap<>();

  public Channel getChannel() {
    return channel;
  }

  public SocketAddress getRemotePeer() {
    return this.remotePeer;
  }

  @Override
  public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
    super.channelRegistered(ctx);
    this.channel = ctx.channel();
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    super.channelActive(ctx);
    this.remotePeer = ctx.channel().remoteAddress();
  }

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcResponse response)
      throws Exception {
    String requestId = response.getRequestId();
    RpcFuture future = pendingRpcTable.get(requestId);
    if (null != future) {
      pendingRpcTable.remove(requestId);
      future.done(response);
    }
  }

  /**
   *@Description netty提供用于主动关闭连接的方式，发送.Unpooled.EMPTY_BUFFER
   *@Author wusx
   *@Date 11:25 2020/6/25
   *@Modified
   */
  public void close() {
    this.channel.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
  }

  /**
   *@Description 异步发送请求的方法.
   *@Author wusx
   *@Date 11:47 2020/6/26
   *@Modified
   */
  public RpcFuture sendRequest(RpcRequest request) {
    RpcFuture future = new RpcFuture(request);
    pendingRpcTable.put(request.getRequestId(), future);
    channel.writeAndFlush(request);
    return future;
  }
}
