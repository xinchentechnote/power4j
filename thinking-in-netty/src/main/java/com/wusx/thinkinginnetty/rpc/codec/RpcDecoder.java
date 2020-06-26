package com.wusx.thinkinginnetty.rpc.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:18 2020/6/21.
 * @Modified By:
 */
public class RpcDecoder extends ByteToMessageDecoder {

  private Class<?> genericClass;

  public RpcDecoder(Class<?> genericClass) {
    this.genericClass = genericClass;
  }

  @Override
  protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
    //如果读取不到长度，直接返回
    if (in.readableBytes() < 4) {
      return;
    }
    //记录当前的读下标
    in.markReaderIndex();
    int dataLength = in.readInt();
    //如果还不足一包数据，直接返回
    if (in.readableBytes() < dataLength) {
      in.resetReaderIndex();
      return;
    }
    //读取数据包
    byte[] data = new byte[dataLength];
    in.readBytes(data);
    //反序列化
    Object object = Serialization.deserialize(data, genericClass);
    out.add(object);
  }
}
