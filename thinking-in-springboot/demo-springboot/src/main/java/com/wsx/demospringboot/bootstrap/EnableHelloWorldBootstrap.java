package com.wsx.demospringboot.bootstrap;

import com.wsx.demospringboot.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:57 2020/3/31.
 * @Modified By:
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(
        EnableHelloWorldBootstrap.class)
        .web(WebApplicationType.NONE)
        .run(args);
    System.out.println(applicationContext.getBean("helloWorld"));
  }
}
