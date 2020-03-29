package com.wusx.thinking.in.spring.bean.definition;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:14 2020/3/29.
 * @Modified By:
 */
public class BeanAliasDemo {

  public static void main(String[] args) {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext(
        "META-INF/bean-definition-context.xml");
    User aliasUser = beanFactory.getBean("aliasUser", User.class);
    User user = beanFactory.getBean("user", User.class);
    System.out.println(aliasUser == user);
  }
}
