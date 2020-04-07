package com.wusx.thinking.in.spring.dependency.lookup;

import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:51 2020/3/30.
 * @Modified By:
 */
public class HierarchicalBeanFactoryDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(HierarchicalBeanFactoryDemo.class);
    ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
    beanFactory.setParentBeanFactory(createParentFactory());
    BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
    System.out.println("当前beanFactory的父容器" + parentBeanFactory);
    context.refresh();

    boolean demo = beanFactory.containsLocalBean("demo");
    Map<String, Token> beansOfType = beanFactory.getBeansOfType(Token.class);
    System.out.println(beansOfType);
    System.out.println(demo);

    context.close();
  }

  private static BeanFactory createParentFactory() {
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    int i = reader.loadBeanDefinitions("classpath:/META-INF/hierarchical-context.xml");
    System.out.println(i);
    return beanFactory;
  }
}
