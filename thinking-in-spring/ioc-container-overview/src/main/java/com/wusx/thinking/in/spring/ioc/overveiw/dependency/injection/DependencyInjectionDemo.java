package com.wusx.thinking.in.spring.ioc.overveiw.dependency.injection;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import com.wusx.thinking.in.spring.ioc.overveiw.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 19:30 2020/3/29.
 * @Modified By:
 */
public class DependencyInjectionDemo {

  public static void main(String[] args) {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext(
        "META-INF/dependency-injection-context.xml");
    /** 自定义bean.*/
    UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
    System.out.println(userRepository.getUsers());
    /** 内建依赖（非bean）.*/
    whoIsIocContainer(beanFactory, userRepository);
    ObjectFactory<User> userObjectFactory = userRepository.getUserObjectFactory();
    System.out.println(userObjectFactory);
    System.out.println(userObjectFactory.getObject());
    ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
    System.out.println(objectFactory);
    System.out.println(objectFactory.getObject());
    /** 内建依赖（非bean）无法直接依赖查找.*/
    //System.out.println(beanFactory.getBean(BeanFactory.class));
    //System.out.println(beanFactory.getBean(ApplicationContext.class));
    /** 容器内建bean.*/
    Environment environment = beanFactory.getBean(Environment.class);
    System.out.println(environment);
  }

  /**
   *@Description 内建依赖（非bean）.
   *@params beanFactory 实际上是ApplicationContext
   *@return
   *@Author  wusx
   *@Date 20:18 2020/3/29
   *@Modified
   */
  private static void whoIsIocContainer(BeanFactory beanFactory, UserRepository userRepository) {
    /**获取的是 DefaultListableBeanFactory，beanFactory是IoC容器的底层实现.*/
    BeanFactory beanFactory1 = userRepository.getBeanFactory();
    //谁才是IoC container
    //beanFactory 实际上是ApplicationContext
    //ApplicationContext内部组合了DefaultListableBeanFactory，以拥有beanFactory的能力，类似于代理模式
    System.out.println(beanFactory==beanFactory1);
    //getAutowireCapableBeanFactory能获取到实际的底层beanFactory
    System.out.println(((ApplicationContext)beanFactory).getAutowireCapableBeanFactory()==beanFactory1);
  }


}
