package com.wusx.thinking.in.spring.bean.definition;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 常规实例化方法.
 * @Author:ShangxiuWu
 * @Date: 22:52 2020/3/29.
 * @Modified By:
 */
public class BeanInstantiationDemo {

  public static void main(String[] args) {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext(
        "classpath:META-INF/bean-instantiation-context.xml");
    User userByStaticMethod = beanFactory.getBean("user-by-static-method", User.class);
    User userByFactoryMethod = beanFactory.getBean("user-by-factory-method", User.class);
    User userByFactoryBeanMethod = beanFactory.getBean("user-by-factory-bean", User.class);
    System.out.println(userByStaticMethod);
    System.out.println(userByFactoryMethod);
    System.out.println(userByFactoryBeanMethod);
    System.out.println(userByStaticMethod == userByFactoryMethod);
    System.out.println(userByStaticMethod == userByFactoryBeanMethod);
  }

}
