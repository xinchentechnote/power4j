package com.wusx.thinkinginnetty.disruptor;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:30 2020/6/22.
 * @Modified By:
 */
@Data
public class TranslatorDataWrapper {
  private TranslatorData translatorData;
  private ChannelHandlerContext ctx;
}
