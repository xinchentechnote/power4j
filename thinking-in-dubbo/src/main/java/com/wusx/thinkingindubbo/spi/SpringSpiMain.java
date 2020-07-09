package com.wusx.thinkingindubbo.spi;

import java.util.List;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * @Description java SPI 测试.
 * @Author:ShangxiuWu
 * @Date: 17:07 2020/7/9.
 * @Modified By:
 */
public class SpringSpiMain {

  public static void main(String[] args) {
    //SpringFactoriesLoader加载
    List<HelloSpiService> helloSpiServices = SpringFactoriesLoader
        .loadFactories(HelloSpiService.class, HelloSpiService.class.getClassLoader());
    helloSpiServices.forEach(s -> {
      System.out.println(s.hello("sutpc"));
    });

  }
}
