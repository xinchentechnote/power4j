package com.wusx.thinking.in.spring.bean.factory;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:58 2020/3/29.
 * @Modified By:
 */
public class DefaultUserFactory implements UserFactory, InitializingBean {


  /**
   *@Description 基于PostConstruct.
   *@params
   *@return
   *@Author wusx
   *@Date 23:43 2020/3/29
   *@Modified
   */
  @PostConstruct
  public void init() {
    System.out.println("@PostConstruct:DefaultUserFactory 初始化");
  }

  public void initUserFactory() {
    System.out.println("自定义 initUserFactory():DefaultUserFactory 初始化 DefaultUserFactory");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("InitializingBean#afterPropertiesSet 初始化");
  }
}
