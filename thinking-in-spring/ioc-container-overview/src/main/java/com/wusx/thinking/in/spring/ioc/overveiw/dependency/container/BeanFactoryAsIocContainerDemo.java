package com.wusx.thinking.in.spring.ioc.overveiw.dependency.container;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import java.util.Map;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.env.Environment;

/**
 * @Description beanFactory作为IoC容器.
 * @Author:ShangxiuWu
 * @Date: 20:57 2020/3/29.
 * @Modified By:
 */
public class BeanFactoryAsIocContainerDemo {

  public static void main(String[] args) {
    //创建BeanFactory容器
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    //xml配置文件路径
    String location = "classpath:META-INF/dependency-lookup-context.xml";
    //加载配置，返回加载的bean数量
    int definitions = reader.loadBeanDefinitions(location);
    System.out.println(definitions);
    Map<String, User> beansOfType = beanFactory.getBeansOfType(User.class);
    System.out.println(beansOfType);
    System.out.println(beanFactory.getBean(Environment.class));
  }
}
