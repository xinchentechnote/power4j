package com.wusx.thinkinginnetty.sever;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 15:45 2020/6/10.
 * @Modified By:
 */
public class Server {

  private final int port;
  private NioEventLoopGroup bossGroup;
  private NioEventLoopGroup workerGroup;
  private ServerBootstrap serverBootstrap;

  public Server(int port) {
    this.port = port;
    bossGroup = new NioEventLoopGroup();
    workerGroup = new NioEventLoopGroup();
    serverBootstrap = new ServerBootstrap();
    serverBootstrap
        .group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .handler(new LoggingHandler(LogLevel.DEBUG))
        .option(ChannelOption.SO_BACKLOG, 1024)
        .childOption(ChannelOption.SO_KEEPALIVE, true)
        .childOption(ChannelOption.TCP_NODELAY, true)
        .childHandler(new ChannelInitializer<NioSocketChannel>() {
          @Override
          protected void initChannel(NioSocketChannel ch) {
            ChannelPipeline pipeline = ch.pipeline();
            pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
            pipeline.addLast(new IdleStateHandler(10, 10, 20));
            pipeline.addLast(new ServerHandler());
          }
        });
  }

  public void start() {
    ChannelFuture bind = this.serverBootstrap.bind(this.port);
    bind.addListener(future -> {
      if (future.isSuccess()) {
        System.out.println("端口绑定成功!");
      } else {
        System.err.println("端口绑定失败!");
      }
    });
  }

  public void stop() {
    bossGroup.shutdownGracefully();
    workerGroup.shutdownGracefully();
  }

  public static void main(String[] args) {
    Server server = new Server(8000);
    server.start();
  }

}
