package com.wusx.thinkingindubbo.spi;

import java.util.List;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * @Description java SPI 测试.
 * @Author:ShangxiuWu
 * @Date: 17:07 2020/7/9.
 * @Modified By:
 */
public class DubboSpiMain {

  public static void main(String[] args) {
    //ExtensionLoader加载
    ExtensionLoader<HelloSpiService> extensionLoader = ExtensionLoader
        .getExtensionLoader(HelloSpiService.class);
    HelloSpiService defaultExtension = extensionLoader.getDefaultExtension();
    System.out.println(defaultExtension.hello("default"));
    HelloSpiService s1 = extensionLoader.getExtension("s1");
    System.out.println(s1.hello("haha"));
    HelloSpiService s2 = extensionLoader.getExtension("s2");
    System.out.println(s2.hello("haha"));

  }
}
