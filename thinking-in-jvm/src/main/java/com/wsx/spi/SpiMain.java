package com.wsx.spi;

import java.io.InputStream;
import java.util.Iterator;
import java.util.ServiceLoader;
import sun.misc.Service;

/**
 * @Description java SPI 测试.
 * @Author:ShangxiuWu
 * @Date: 17:07 2020/7/9.
 * @Modified By:
 */
public class SpiMain {

  public static void main(String[] args) {
    //ServiceLoader加载
    ServiceLoader<HelloSpiService> load = ServiceLoader.load(HelloSpiService.class);
    load.forEach(s -> {
      System.out.println(s.hello("sutpc"));
    });
    //Service加载
    Iterator<HelloSpiService> providers = Service.providers(HelloSpiService.class);
    providers.forEachRemaining(s->{
      System.out.println(s.hi("world"));
    });

    InputStream systemResourceAsStream = ClassLoader
        .getSystemResourceAsStream("META-INF/services/com.wsx.spi.HelloSpiService");
    System.out.println();

  }
}
