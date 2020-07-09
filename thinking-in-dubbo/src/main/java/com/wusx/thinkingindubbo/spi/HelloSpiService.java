package com.wusx.thinkingindubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 17:03 2020/7/9.
 * @Modified By:
 */
@SPI("s1")
public interface HelloSpiService {

  String hello(String name);

  String hi(String name);
}
