package com.wusx.thinkinginnetty.disruptor;

import com.lmax.disruptor.WorkHandler;
import lombok.Data;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:25 2020/6/22.
 * @Modified By:
 */
@Data
public abstract class MessageConsumer implements WorkHandler<TranslatorDataWrapper> {

  private String consumerId;

  public MessageConsumer(String consumerId) {
    this.consumerId = consumerId;
  }

}
