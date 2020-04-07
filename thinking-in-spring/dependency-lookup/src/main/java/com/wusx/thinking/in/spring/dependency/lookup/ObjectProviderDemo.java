package com.wusx.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Description 通过 {@link ObjectProvider}进行依赖查找.
 * @Author:ShangxiuWu
 * @Date: 22:13 2020/3/30.
 * @Modified By:
 */
public class ObjectProviderDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(ObjectProviderDemo.class);
    context.refresh();
    lookupByObjectProvider(context);

  }

  @Bean
  public String hello() {
    return "hello world";
  }

  private static void lookupByObjectProvider(AnnotationConfigApplicationContext context) {
    ObjectProvider<String> beanProvider = context.getBeanProvider(String.class);
    System.out.println(beanProvider.getIfAvailable());
  }
}
