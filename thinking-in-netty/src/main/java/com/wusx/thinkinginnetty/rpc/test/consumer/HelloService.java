package com.wusx.thinkinginnetty.rpc.test.consumer;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 13:32 2020/6/26.
 * @Modified By:
 */
public interface HelloService {
  String hello(String name);
  String hello(User user);
}
