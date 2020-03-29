package com.wusx.thinking.in.spring.bean.definition;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @Description 通过@Import导入.
 * @Author:ShangxiuWu
 * @Date: 22:20 2020/3/29.
 * @Modified By:
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

  public static void main(String[] args) {
    //创建BeanFactory容器
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    //注册Configuration class
    context.register(Config.class);
    //1、通过@Bean方式定义

    //2、通过@Component方式

    //3、通过@Import导入

    //命名
    registerBeanDefinition(context, "user-wahaha", User.class);
    registerBeanDefinition(context, User.class);
    //非命名
    context.refresh();
    System.out.println(context.getBeansOfType(Config.class));
    System.out.println(context.getBeansOfType(User.class));

    //显式关闭spring应用上下文
    context.close();
  }

  /**
   *@Description 命名bean的注册方式.
   *@params
   *@return
   *@Author wusx
   *@Date 22:36 2020/3/29
   *@Modified
   */
  public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName,
      Class<?> beanClass) {
    BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(beanClass);
    beanDefinitionBuilder.addPropertyValue("id", 10086)
        .addPropertyValue("name", "命名方式");
    registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
  }

  /**
   *@Description 非命名方式.
   *@params
   *@return
   *@Author wusx
   *@Date 22:39 2020/3/29
   *@Modified
   */
  public static void registerBeanDefinition(BeanDefinitionRegistry registry,
      Class<?> beanClass) {
    BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(beanClass);
    beanDefinitionBuilder.addPropertyValue("id", 10010)
        .addPropertyValue("name", "非命名方式");
    BeanDefinitionReaderUtils
        .registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
  }

  /**
   *@Description .
   *@params 通过@Component方式
   *@return
   *@Author wusx
   *@Date 22:32 2020/3/29
   *@Modified
   */
  @Component
  public static class Config {

    /**
     *@Description 通过@Bean方式定义.
     *@params
     *@return
     *@Author wusx
     *@Date 22:32 2020/3/29
     *@Modified
     */
    @Bean(name = {"zhutou", "user", "wahaha"})
    public User user() {
      User user = new User();
      user.setId(100L);
      user.setName("猪头");
      return user;
    }

  }
}
