package com.wusx.thinking.in.spring.bean.definition;

import com.wusx.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.wusx.thinking.in.spring.bean.factory.UserFactory;
import java.util.Map;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description bean初始化方法.
 * @Author:ShangxiuWu
 * @Date: 23:40 2020/3/29.
 * @Modified By:
 */
@Configuration
public class BeanInitializingDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(BeanInitializingDemo.class);
    context.refresh();
    Map<String, UserFactory> beansOfType = context.getBeansOfType(UserFactory.class);
    System.out.println(beansOfType);
    context.close();
  }

  @Bean(initMethod = "initUserFactory")
  public DefaultUserFactory defaultUserFactory() {
    return new DefaultUserFactory();
  }

}
