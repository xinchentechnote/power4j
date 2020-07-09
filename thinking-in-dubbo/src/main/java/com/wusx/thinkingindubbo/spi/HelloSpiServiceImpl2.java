package com.wusx.thinkingindubbo.spi;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 17:05 2020/7/9.
 * @Modified By:
 */
public class HelloSpiServiceImpl2 implements HelloSpiService {

  @Override
  public String hello(String name) {
    return "hello " + name + " impl_2";
  }

  @Override
  public String hi(String name) {
    return "hi " + name + " impl_2";
  }

}
