package com.wusx.thinkinginnetty.rpc.client;

import com.wusx.thinkinginnetty.rpc.codec.RpcDecoder;
import com.wusx.thinkinginnetty.rpc.codec.RpcEncoder;
import com.wusx.thinkinginnetty.rpc.codec.RpcRequest;
import com.wusx.thinkinginnetty.rpc.codec.RpcResponse;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:21 2020/6/21.
 * @Modified By:
 */
public class RpcClientInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline = ch.pipeline();
    //拆包
    //二次解码
    pipeline.addLast(new LengthFieldBasedFrameDecoder(65535, 0, 4, 0, 0));
    pipeline.addLast(new RpcDecoder(RpcResponse.class));
    pipeline.addLast(new RpcEncoder(RpcRequest.class));
    //客户端业务处理器
    pipeline.addLast(new RpcClientHandler());
  }
}
