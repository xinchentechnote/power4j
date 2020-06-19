package com.wusx.thinkinginnetty.sever;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 9:38 2020/6/19.
 * @Modified By:
 */
@Slf4j
public class ServerHandler extends SimpleChannelInboundHandler {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

  }


  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    // 获取idle事件
    if (evt instanceof IdleStateEvent) {
      IdleStateEvent event = (IdleStateEvent) evt;
      // 读等待事件
      if (event.state() == IdleState.READER_IDLE) {
        log.info("{}+ 超时无心跳... ", ctx.channel().remoteAddress());
        ctx.close();
      }
    } else {
      super.userEventTriggered(ctx, evt);
    }
  }
}
