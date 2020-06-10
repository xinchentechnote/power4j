package com.wusx.thinkinginnetty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 15:32 2020/6/10.
 * @Modified By:
 */
@Slf4j
public class ClientHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    log.error("{},断开连接...",ctx.channel().remoteAddress());
    super.channelInactive(ctx);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    log.error(cause.getMessage());
    ctx.close();
  }
}
