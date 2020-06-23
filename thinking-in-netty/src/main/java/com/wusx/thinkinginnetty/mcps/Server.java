package com.wusx.thinkinginnetty.mcps;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 9:45 2020/6/23.
 * @Modified By:
 */
@Slf4j
public class Server {

  public static void main(String[] args) {
    new Server().start(ConnectConstant.BEGIN_PORT, ConnectConstant.PORT_NUM);
  }

  public void start(int beginPort, int portNum) {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    ServerBootstrap bootstrap = new ServerBootstrap();
    bootstrap.group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .childOption(ChannelOption.SO_REUSEADDR, true)
        .childHandler(new ConnectCountHandler());
    for (int port = 0; port < portNum; port++) {
      int inetPort = beginPort + port;
      bootstrap.bind(inetPort).addListener((ChannelFutureListener) future -> {
        log.info("server bind port : {}", inetPort);
      });
    }
  }

}
