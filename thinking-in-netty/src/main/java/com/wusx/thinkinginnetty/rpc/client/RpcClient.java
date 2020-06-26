package com.wusx.thinkinginnetty.rpc.client;

import com.wusx.thinkinginnetty.rpc.client.proxy.RpcAsyncProxy;
import com.wusx.thinkinginnetty.rpc.client.proxy.RpcProxyImpl;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:14 2020/6/21.
 * @Modified By:
 */
public class RpcClient {

  private String serverAddress;
  private long timeout;

  private final Map<Class<?>, Object> syncProxyInstanceMap = new ConcurrentHashMap<>();
  private final Map<Class<?>, Object> asyncProxyInstanceMap = new ConcurrentHashMap<>();

  public void initClient(String serverAddress, long timeout) {
    this.serverAddress = serverAddress;
    this.timeout = timeout;
    connect();
  }

  private void connect() {
    RpcConnectManager.getInstance().connect(serverAddress);
  }


  public void stop() {
    RpcConnectManager.getInstance().stop();
  }


  /**
   *@Description 同步调用.
   *@params
   *@return
   *@Author  wusx
   *@Date 13:11 2020/6/26
   *@Modified
   */
  public <T> T invokeSync(Class<T> interfaceClass) {

    if (syncProxyInstanceMap.containsKey(interfaceClass)) {
      return (T) syncProxyInstanceMap.get(interfaceClass);
    }

    Object proxy = Proxy.newProxyInstance(interfaceClass.getClassLoader(),
        new Class<?>[]{interfaceClass},
        new RpcProxyImpl<>(interfaceClass, timeout)
    );

    syncProxyInstanceMap.put(interfaceClass, proxy);

    return (T) proxy;

  }


  /**
   *@Description 异步调用.
   *@params
   *@return
   *@Author  wusx
   *@Date 13:11 2020/6/26
   *@Modified
   */
  public <T> RpcAsyncProxy invokeAsync(Class<T> interfaceClass) {

    if (asyncProxyInstanceMap.containsKey(interfaceClass)) {
      return (RpcAsyncProxy) asyncProxyInstanceMap.get(interfaceClass);
    }

    RpcProxyImpl<T> asyncProxyImpl = new RpcProxyImpl<>(interfaceClass, timeout);

    syncProxyInstanceMap.put(interfaceClass, asyncProxyImpl);

    return asyncProxyImpl;

  }


}
