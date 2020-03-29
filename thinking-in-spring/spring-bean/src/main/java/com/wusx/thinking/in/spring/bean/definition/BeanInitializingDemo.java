package com.wusx.thinking.in.spring.bean.definition;

import com.wusx.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.wusx.thinking.in.spring.bean.factory.UserFactory;
import java.util.Map;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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
    System.out.println("-------ApplicationContext已启动--------");
    UserFactory bean = context.getBean(UserFactory.class);
    System.out.println(bean);
    System.out.println("-------ApplicationContext准备关闭--------");
    context.close();
    System.out.println("-------ApplicationContext已关闭--------");
  }

  @Bean(initMethod = "initUserFactory",destroyMethod = "doDestroy")
  @Lazy(false)
  public DefaultUserFactory defaultUserFactory() {
    return new DefaultUserFactory();
  }

}
