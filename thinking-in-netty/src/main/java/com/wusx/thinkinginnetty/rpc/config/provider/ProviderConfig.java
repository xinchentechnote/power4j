package com.wusx.thinkinginnetty.rpc.config.provider;

import com.wusx.thinkinginnetty.rpc.config.RpcConfigAbstract;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:17 2020/6/21.
 * @Modified By:
 */
public class ProviderConfig extends RpcConfigAbstract {

  private Object ref;

  public Object getRef() {
    return ref;
  }

  public void setRef(Object ref) {
    this.ref = ref;
  }
}
