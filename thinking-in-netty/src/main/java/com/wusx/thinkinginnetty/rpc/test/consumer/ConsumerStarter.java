package com.wusx.thinkinginnetty.rpc.test.consumer;

import com.wusx.thinkinginnetty.rpc.client.RpcClient;
import com.wusx.thinkinginnetty.rpc.client.RpcFuture;
import com.wusx.thinkinginnetty.rpc.client.proxy.RpcAsyncProxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 13:32 2020/6/26.
 * @Modified By:
 */
public class ConsumerStarter {

  public static void main(String[] args) {
//    sync();
    try {
      async();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (TimeoutException e) {
      e.printStackTrace();
    }
  }

  private static void sync() {
    RpcClient rpcClient = new RpcClient();
    rpcClient.initClient("127.0.0.1:9988", 3000);
    HelloService helloService = rpcClient.invokeSync(HelloService.class);
    String wusx = helloService.hello("wusx");
    System.out.println(wusx);
    String user = helloService.hello(new User("2", "ap0908"));
    System.out.println(user);
  }


  private static void async() throws ExecutionException, InterruptedException, TimeoutException {
    RpcClient rpcClient = new RpcClient();
    rpcClient.initClient("127.0.0.1:9988", 3000);
    RpcAsyncProxy rpcAsyncProxy = rpcClient.invokeAsync(HelloService.class);
    RpcFuture future = rpcAsyncProxy.call("hello", "wusx");
    RpcFuture userFuture = rpcAsyncProxy.call("hello", new User("1", "sutpc"));
    System.out.println(future.get());
    System.out.println(userFuture.get());
//    System.out.println(future.get(2, TimeUnit.SECONDS));
//    System.out.println(userFuture.get(2, TimeUnit.SECONDS));
  }


}
