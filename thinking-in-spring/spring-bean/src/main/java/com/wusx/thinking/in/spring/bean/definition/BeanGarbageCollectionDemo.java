package com.wusx.thinking.in.spring.bean.definition;

import com.wusx.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 0:25 2020/3/30.
 * @Modified By:
 */
public class BeanGarbageCollectionDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(BeanInitializingDemo.class);
    context.refresh();
    context.close();
    System.out.println("-------ApplicationContext已关闭--------");
    System.gc();
  }
}
