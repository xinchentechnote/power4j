package com.wusx.thinking.in.spring.bean.definition;

import com.wusx.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.wusx.thinking.in.spring.bean.factory.UserFactory;
import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import java.util.Iterator;
import java.util.ServiceLoader;
import javax.sound.midi.Soundbank;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 特殊实例化方法.
 * @Author:ShangxiuWu
 * @Date: 22:52 2020/3/29.
 * @Modified By:
 */
public class SpecialBeanInstantiationDemo {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "classpath:META-INF/special-bean-instantiation-context.xml");
    //通过applicationContext获取AutowireCapableBeanFactory
    AutowireCapableBeanFactory beanFactory = applicationContext
        .getAutowireCapableBeanFactory();
    //demoServiceLoader();
    ServiceLoader<UserFactory> load = beanFactory
        .getBean("userFactoryServiceLoader", ServiceLoader.class);
    Iterator<UserFactory> iterator = load.iterator();
    while (iterator.hasNext()) {
      UserFactory next = iterator.next();
      System.out.println(next);
      System.out.println(next.createUser());
    }

    //创建UserFactory对象
    DefaultUserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
    System.out.println(userFactory.createUser());

  }

  public static void demoServiceLoader() {
    ServiceLoader<UserFactory> load = ServiceLoader
        .load(UserFactory.class, Thread.currentThread().getContextClassLoader());
    Iterator<UserFactory> iterator = load.iterator();
    while (iterator.hasNext()) {
      UserFactory next = iterator.next();
      System.out.println(next);
      System.out.println(next.createUser());
    }
  }

}
