package com.wusx.thinking.in.spring.ioc.overveiw.dependency.container;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import java.util.Map;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Description beanFactory作为IoC容器.
 * @Author:ShangxiuWu
 * @Date: 20:57 2020/3/29.
 * @Modified By:
 */
@Configuration
public class AnnotationApplicationContextAsIocContainerDemo {

  @Bean
  public User user() {
    User user = new User();
    user.setId(2L);
    user.setName("吴上秀");
    return user;
  }

  public static void main(String[] args) {
    //创建ApplicationContext容器
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(AnnotationApplicationContextAsIocContainerDemo.class);
    //启动应用上下文
    context.refresh();
    Map<String, User> beansOfType = context.getBeansOfType(User.class);
    System.out.println(beansOfType);
    System.out.println(context.getBean(Environment.class));
    //停止
    context.close();
  }
}
