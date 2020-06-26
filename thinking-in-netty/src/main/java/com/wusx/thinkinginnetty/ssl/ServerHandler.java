package com.wusx.thinkinginnetty.ssl;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 17:27 2020/6/23.
 * @Modified By:
 */
@Slf4j
@Sharable
public class ServerHandler extends SimpleChannelInboundHandler<String> {

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    ctx.writeAndFlush("hello client.\n");
    super.channelReadComplete(ctx);
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    log.info(msg);
    ctx.writeAndFlush(msg);
  }
}
