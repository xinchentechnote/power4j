package com.wusx.thinkinginnetty.rpc.test.provider;

import com.wusx.thinkinginnetty.rpc.test.consumer.HelloService;
import com.wusx.thinkinginnetty.rpc.test.consumer.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 13:33 2020/6/26.
 * @Modified By:
 */
@Slf4j
public class HelloServiceImpl implements HelloService {

  @Override
  public String hello(String name) {
    return "hello " + name;
  }

  @Override
  public String hello(User user) {
    return "hello user " + user.getName();
  }
}
