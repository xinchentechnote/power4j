package com.wusx.thinkinginnetty.mcps;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 9:46 2020/6/23.
 * @Modified By:
 */
@Slf4j
public class Client {

  public static void main(String[] args) {
    new Client().start(ConnectConstant.BEGIN_PORT, ConnectConstant.PORT_NUM);
  }

  public void start(int beginPort, int portNum) {
    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    Bootstrap bootstrap = new Bootstrap();
    bootstrap.group(eventLoopGroup)
        .channel(NioSocketChannel.class)
        .option(ChannelOption.SO_REUSEADDR, true)
        .handler(new ChannelInitializer<NioSocketChannel>() {
          @Override
          protected void initChannel(NioSocketChannel ch) throws Exception {

          }
        });
    int index = 0;
    int serverPort;
    while (!Thread.interrupted()) {
      serverPort = index + beginPort;
      try {
        ChannelFuture channelFuture = bootstrap.connect(ConnectConstant.SERVER_HOST, serverPort);
        channelFuture.addListener((ChannelFutureListener) future -> {
          if (!future.isSuccess()) {
            log.error("connect failed...");
            System.exit(0);
          }
        });
      } catch (Exception e) {
        log.error("connect exception:{}", e.getMessage());
      }
      index++;
      index %= portNum;
    }

  }

}
