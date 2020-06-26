package com.wusx.thinkinginnetty.rpc.codec;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:19 2020/6/21.
 * @Modified By:
 */
@Data
public class RpcResponse implements Serializable {

  private String requestId;
  private Object result;
  private Throwable throwable;

}
