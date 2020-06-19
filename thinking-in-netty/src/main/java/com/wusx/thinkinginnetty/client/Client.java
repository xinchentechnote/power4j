package com.wusx.thinkinginnetty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 14:50 2020/6/10.
 * @Modified By:
 */
@Slf4j
public class Client {

  static int MAX_RETRY = 10;
  private String host;
  private int port;

  private NioEventLoopGroup workerGroup;
  private Bootstrap bootstrap;
  private Channel channel;

  public Client(String host, int port) {
    this.host = host;
    this.port = port;
    workerGroup = new NioEventLoopGroup();
    bootstrap = new Bootstrap();
    bootstrap
        .group(workerGroup)
        .channel(NioSocketChannel.class)
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
        .option(ChannelOption.SO_KEEPALIVE, true)
        .option(ChannelOption.TCP_NODELAY, true)
        .handler(new ChannelInitializer<SocketChannel>() {
          @Override
          public void initChannel(SocketChannel ch) {
            ChannelPipeline pipeline = ch.pipeline();
            pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
            pipeline.addLast(new ClientHandler());
          }
        });
  }

  public void connect(int retry) {
    ChannelFuture connect = this.bootstrap.connect(this.host, this.port);
    connect.addListener(future -> {
      if (future.isSuccess()) {
        log.info("{}-{}-连接成功!", connect.channel().localAddress(),
            connect.channel().remoteAddress());
        this.channel = connect.channel();
        final Client client = this;
        connect.channel().closeFuture().addListener(f -> {
          client.connect(MAX_RETRY);
        });
      } else if (retry == 0) {
        log.error("重试次数已达最大限制，放弃连接！");
      } else {
        int order = (MAX_RETRY - retry) + 1;
        int delay = 1 << order;
        log.error("连接失败，第{}次重连……", order);
        bootstrap.config().group()
            .schedule(() -> this.connect(retry - 1), delay, TimeUnit
                .SECONDS);
      }
    });
  }

  public static void main(String[] args) {
    Client client = new Client("127.0.0.1", 8000);
    client.connect(MAX_RETRY);
  }
}
