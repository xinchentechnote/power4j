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
        "META-INFO/dependency-injection-context.xml");
    /** 自定义bean.*/
    UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
    System.out.println(userRepository.getUsers());
    /** 内建依赖（非bean）.*/
    BeanFactory beanFactory1 = userRepository.getBeanFactory();
    System.out.println(beanFactory);
    System.out.println(beanFactory1);
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
}
