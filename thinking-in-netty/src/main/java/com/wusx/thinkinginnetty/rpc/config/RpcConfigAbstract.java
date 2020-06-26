package com.wusx.thinkinginnetty.rpc.config;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.util.StringUtils;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:16 2020/6/21.
 * @Modified By:
 */
public abstract class RpcConfigAbstract {

  private AtomicInteger generator = new AtomicInteger();

  protected String id;

  protected String interfaceClass = null;

  protected  Class<?> proxyClass = null;

  public String getId() {
    if (StringUtils.isEmpty(id)){
      id = "rapid-cfg-gen-"+generator.getAndIncrement();
    }
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getInterfaceClass() {
    return interfaceClass;
  }

  public void setInterfaceClass(String interfaceClass) {
    this.interfaceClass = interfaceClass;
  }
}
