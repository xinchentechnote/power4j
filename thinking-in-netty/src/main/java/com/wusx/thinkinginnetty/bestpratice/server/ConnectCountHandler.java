package com.wusx.thinkinginnetty.bestpratice.server;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 23:25 2020/6/22.
 * @Modified By:
 */
@Sharable
@Slf4j
public class ConnectCountHandler extends ChannelInboundHandlerAdapter {

  private AtomicLong connectCount = new AtomicLong();

  public ConnectCountHandler() {
    Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
          log.info("connect count :{}", connectCount.get());
        },
        0, 2, TimeUnit.SECONDS);
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    connectCount.getAndIncrement();
    super.channelActive(ctx);
  }

  @Override
  public void channelInactive(ChannelHandlerContext ctx) throws Exception {
    connectCount.getAndDecrement();
    super.channelInactive(ctx);
  }
}
