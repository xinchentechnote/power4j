package com.wusx.thinking.in.spring.bean.definition;

import com.wusx.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.wusx.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description 外部单体对象.
 * @Author:ShangxiuWu
 * @Date: 0:30 2020/3/30.
 * @Modified By:
 */
public class SingletonBeanRegistrationDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    //注册外部单例对象
    UserFactory userFactory = new DefaultUserFactory();
    ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
    beanFactory.registerSingleton("userFactory", userFactory);
    context.refresh();

    UserFactory factory = context.getBean("userFactory", UserFactory.class);

    System.out.println(factory == userFactory);

    context.close();
  }
}
