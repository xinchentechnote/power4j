package com.wusx.thinkinginnetty.rpc.client.proxy;

import com.wusx.thinkinginnetty.rpc.client.RpcClientHandler;
import com.wusx.thinkinginnetty.rpc.client.RpcConnectManager;
import com.wusx.thinkinginnetty.rpc.client.RpcFuture;
import com.wusx.thinkinginnetty.rpc.codec.RpcRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:22 2020/6/21.
 * @Modified By:
 */
public class RpcProxyImpl<T> implements InvocationHandler, RpcAsyncProxy {

  private Class<T> clazz;
  private long timeout;

  public RpcProxyImpl(Class<T> clazz, long timeout) {
    this.clazz = clazz;
    this.timeout = timeout;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //1、设置请求对象
    RpcRequest request = new RpcRequest();
    request.setRequestId(UUID.randomUUID().toString());
    request.setMethodName(method.getName());
    request.setClassName(method.getDeclaringClass().getName());
    request.setParameterTypes(method.getParameterTypes());
    request.setParameters(args);
    //2、选择一个合适的client任务处理器
    RpcClientHandler rpcClientHandler = RpcConnectManager.getInstance().chooseHandler();
    //3、发送真正的客户端请求，等待返回结果
    RpcFuture future = rpcClientHandler.sendRequest(request);
    return future.get(timeout, TimeUnit.SECONDS);
  }

  @Override
  public RpcFuture call(String funcName, Object... args) {
    //1、设置请求对象
    RpcRequest request = new RpcRequest();
    request.setRequestId(UUID.randomUUID().toString());
    request.setClassName(this.clazz.getName());
    request.setMethodName(funcName);

    //TODO 对应的方法参数类型应该通过反射获取
    Class<?>[] parameterTypes = new Class[args.length];
    for (int i = 0; i < args.length; i++) {
      parameterTypes[i] = getClassType(args[i]);
    }
    request.setParameterTypes(parameterTypes);
    request.setParameters(args);
    //2、选择一个合适的client任务处理器
    RpcClientHandler rpcClientHandler = RpcConnectManager.getInstance().chooseHandler();
    //3、发送真正的客户端请求，等待返回结果
    RpcFuture future = rpcClientHandler.sendRequest(request);
    return future;
  }

  private Class<?> getClassType(Object arg) {
    Class<?> aClass = arg.getClass();
    String name = aClass.getName();
    if ("java.lang.Integer".equals(name)) {
      return Integer.TYPE;
    } else if ("java.lang.Long".equals(name)) {
      return Long.TYPE;
    } else if ("java.lang.Float".equals(name)) {
      return Float.TYPE;
    } else if ("java.lang.Double".equals(name)) {
      return Double.TYPE;
    } else if ("java.lang.Character".equals(name)) {
      return Character.TYPE;
    } else if ("java.lang.Boolean".equals(name)) {
      return Boolean.TYPE;
    } else if ("java.lang.Short".equals(name)) {
      return Short.TYPE;
    } else if ("java.lang.Byte".equals(name)) {
      return Byte.TYPE;
    }
    return aClass;
  }
}
