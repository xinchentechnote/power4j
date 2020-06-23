package com.wusx.thinkinginnetty.ssl;

import com.wusx.thinkinginnetty.mcps.ConnectConstant;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 9:46 2020/6/23.
 * @Modified By:
 */
@Slf4j
public class Client {

  private static int PORT = 9999;

  private static String SERVER_HOST = "127.0.0.1";

  public static void main(String[] args) {
    new Client().start(SERVER_HOST, PORT);
  }

  public void start(String host, int port) {
    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    Bootstrap bootstrap = new Bootstrap();
    bootstrap.group(eventLoopGroup)
        .channel(NioSocketChannel.class)
        .option(ChannelOption.SO_REUSEADDR, true)
        .handler(new ChannelInitializer<NioSocketChannel>() {
          @Override
          protected void initChannel(NioSocketChannel ch) throws Exception {
            ChannelPipeline pipeline = ch.pipeline();
            pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
          }
        });

    try {
      ChannelFuture channelFuture = bootstrap.connect(host, port);
      channelFuture.addListener((ChannelFutureListener) future -> {
        if (!future.isSuccess()) {
          log.error("connect failed...");
          System.exit(0);
        }
      });
    } catch (Exception e) {
      log.error("connect exception:{}", e.getMessage());
    }

  }

}
