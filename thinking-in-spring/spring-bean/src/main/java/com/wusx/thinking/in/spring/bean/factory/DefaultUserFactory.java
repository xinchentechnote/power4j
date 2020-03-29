package com.wusx.thinking.in.spring.bean.factory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:58 2020/3/29.
 * @Modified By:
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {


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

  @PreDestroy
  public void preDestroy() {
    System.out.println("preDestroy DefaultUserFactory 销毁...");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("DisposableBean#destroy DefaultUserFactory 销毁...");
  }

  public void doDestroy() {
    System.out.println("自定义doDestroy DefaultUserFactory 销毁...");
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.println("finalize() DefaultUserFactory 正在被回收");
  }
}
