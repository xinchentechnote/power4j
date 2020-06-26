package com.wusx.thinkinginnetty.rpc.client;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:20 2020/6/21.
 * @Modified By:
 */
public interface RpcCallback {

  void success(Object result);

  void failed(Object result);
}
