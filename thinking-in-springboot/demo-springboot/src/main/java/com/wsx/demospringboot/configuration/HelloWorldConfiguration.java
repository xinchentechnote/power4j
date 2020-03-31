package com.wsx.demospringboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:39 2020/3/31.
 * @Modified By:
 */
//@Configuration
public class HelloWorldConfiguration {

  @Bean("helloWorld")
  public String helloWorld() {
    return "hello world";
  }

}
