package com.wusx.thinking.in.spring.bean.definition;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:39 2020/3/29.
 * @Modified By:
 */
public class BeanDefinitionDemo {

  public static void main(String[] args) {
    //1、通过BeanDefinitionBuilder构建
    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
        .genericBeanDefinition(User.class);
    //通过属性设置
    beanDefinitionBuilder.addPropertyValue("id", 1);
    beanDefinitionBuilder.addPropertyValue("name", "吴上秀");
    //获取beanDefinition实例
    //beanDefinition并非bean的终态，可以自定义修改
    BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

    //2、通过AbstractBeanDefinition及其派生类
    GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
    genericBeanDefinition.setBeanClass(User.class);
    MutablePropertyValues values = new MutablePropertyValues();
    values.add("id", 1)
        .add("name", "吴上秀");
    genericBeanDefinition.setPropertyValues(values);

    System.out.println(beanDefinition.equals(genericBeanDefinition));

  }
}
