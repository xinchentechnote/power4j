package com.wusx.thinking.in.spring.ioc.overveiw.dependency.lookup;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.annotation.Super;
import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description 依赖查找示例.
 * @Author:ShangxiuWu
 * @Date: 18:48 2020/3/29.
 * @Modified By:
 */
public class DependencyLookupDemo {

  public static void main(String[] args) {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext(
        "classpath:META-INF/dependency-lookup-context.xml");
    //依赖查找：实时查找
    lookupRealTime(beanFactory);
    //依赖查找：延时查找
    lookupRealLazy(beanFactory);
    //根据类型查找单个对象
    lookupByType(beanFactory);
    //根据类型查找集合对象
    lookupCollectionByType(beanFactory);
    //根据注解查找
    lookupCollectionByAnnotation(beanFactory);

  }

  /**
   *@Description .
   *@params
   *@return
   *@Author wusx
   *@Date 19:16 2020/3/29
   *@Modified
   */
  private static void lookupCollectionByAnnotation(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
      Map<String, User> beans = (Map) listableBeanFactory
          .getBeansWithAnnotation(Super.class);
      System.out.println("根据注解查找：" + beans);
    }
  }

  /**
   *@Description .
   *@params
   *@return
   *@Author wusx
   *@Date 19:16 2020/3/29
   *@Modified
   */
  private static void lookupCollectionByType(BeanFactory beanFactory) {
    if (beanFactory instanceof ListableBeanFactory) {
      ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
      Map<String, User> beansMap = listableBeanFactory.getBeansOfType(User.class);
      System.out.println("根据类型查找集合对象：" + beansMap);
    }
  }

  /**
   *@Description .
   *@params
   *@return
   *@Author wusx
   *@Date 19:16 2020/3/29
   *@Modified
   */
  private static void lookupByType(BeanFactory beanFactory) {
    User bean = beanFactory.getBean(User.class);
    System.out.println("根据类型查找单个对象：" + bean);
  }

  /**
   *@Description 实时查找.
   *@params
   *@return
   *@Author wusx
   *@Date 19:04 2020/3/29
   *@Modified
   */
  private static void lookupRealTime(BeanFactory beanFactory) {
    User user = (User) beanFactory.getBean("user");
    System.out.println("实时查找：" + user);
  }


  /**
   *@Description 延时查找.
   *@params
   *@return
   *@Author wusx
   *@Date 19:04 2020/3/29
   *@Modified
   */
  private static void lookupRealLazy(BeanFactory beanFactory) {
    ObjectFactory<User> objectFactory = (ObjectFactory) beanFactory.getBean("objectFactory");
    System.out.println("延时查找：" + objectFactory.getObject());
  }
}
