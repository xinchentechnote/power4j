package com.wusx.thinkinginnetty.rpc.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:18 2020/6/21.
 * @Modified By:
 */
public class RpcEncoder extends MessageToByteEncoder<Object> {

  private Class<?> genericClass;

  public RpcEncoder(Class<?> genericClass) {
    this.genericClass = genericClass;
  }


  /**
   *@Description
   * 1、把对应的java对象进行编码
   * 2、之后把内容写到buffer中
   * 3、写出出去.
   *@Author wusx
   *@Date 14:48 2020/6/25
   *@Modified
   */
  @Override
  protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
    if (genericClass.isInstance(msg)) {
      //通常消息分为：1、消息头，2、消息体两部分
      byte[] bytes = Serialization.serialize(msg);
      out.writeInt(bytes.length);
      out.writeBytes(bytes);
    }
  }
}
