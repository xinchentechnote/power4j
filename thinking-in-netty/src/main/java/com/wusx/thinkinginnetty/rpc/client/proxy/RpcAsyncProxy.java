package com.wusx.thinkinginnetty.rpc.client.proxy;

import com.wusx.thinkinginnetty.rpc.client.RpcFuture;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:22 2020/6/21.
 * @Modified By:
 */
public interface RpcAsyncProxy {

  /**
   *@Description 异步调用.
   *@Author  wusx
   *@Date 13:06 2020/6/26
   *@Modified
   */
  RpcFuture call(String funcName, Object... agrs);
}
