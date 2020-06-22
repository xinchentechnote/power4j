package com.wusx.thinkinginnetty.disruptor;

import com.lmax.disruptor.RingBuffer;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:25 2020/6/22.
 * @Modified By:
 */
public class MessageProducer {

  private RingBuffer<TranslatorDataWrapper> ringBuffer;
  private String producerId;

  public MessageProducer(String producerId,
      RingBuffer<TranslatorDataWrapper> ringBuffer) {
    this.producerId = producerId;
    this.ringBuffer = ringBuffer;
  }

  public void onData(TranslatorData data, ChannelHandlerContext ctx) {
    long sequence = ringBuffer.next();

    try {
      TranslatorDataWrapper translatorDataWrapper = ringBuffer.get(sequence);
      translatorDataWrapper.setTranslatorData(data);
      translatorDataWrapper.setCtx(ctx);
    } finally {
      ringBuffer.publish(sequence);
    }

  }

}
