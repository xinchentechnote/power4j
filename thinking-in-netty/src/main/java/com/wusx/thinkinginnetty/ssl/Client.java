package com.wusx.thinkinginnetty.ssl;

import com.wusx.thinkinginnetty.mcps.ConnectConstant;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

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

  private final static String clientCrt = "ssl/client.crt";
  private final static String clientKey = "ssl/pkcs8_client.key";
  private final static String caCrt = "ssl/ca.crt";
  private final static String keyPassword = "sutpc123";

  public static void main(String[] args) {
    new Client().start(SERVER_HOST, PORT);
  }

  public void start(String host, int port) {
    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    Bootstrap bootstrap = new Bootstrap();
    try {

      final SslContext sslCtx = SslContextBuilder.forClient()
          //双向认证
          .keyManager(new ClassPathResource(clientCrt).getInputStream(),
              new ClassPathResource(clientKey).getInputStream())
          //校验对方证书
          .trustManager(new ClassPathResource(caCrt).getInputStream())
          //不校验server
          //.trustManager(InsecureTrustManagerFactory.INSTANCE)
          .build();
      bootstrap.group(eventLoopGroup)
          .channel(NioSocketChannel.class)
          .option(ChannelOption.SO_REUSEADDR, true)
          .handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
              ChannelPipeline pipeline = ch.pipeline();
              pipeline.addLast(sslCtx.newHandler(ch.alloc()));
              pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
              pipeline.addLast(new LineBasedFrameDecoder(100));
              pipeline.addLast(new StringDecoder());
              pipeline.addLast(new StringEncoder());
              pipeline.addLast(new SimpleChannelInboundHandler<String>() {

                @Override
                public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
                  ctx.writeAndFlush("hello server.\n");
                  super.channelReadComplete(ctx);
                }

                @Override
                protected void channelRead0(ChannelHandlerContext ctx, String msg)
                    throws Exception {
                  log.info(msg);
                  Thread.sleep(1000);
                  ctx.writeAndFlush(msg);
                }
              });
            }
          });
    } catch (Exception e) {
      log.error("启动错误:{}", e.getMessage());
    }

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
