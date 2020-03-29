package com.wusx.thinking.in.spring.ioc.overveiw.dependency.repository;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import java.util.Collection;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 19:32 2020/3/29.
 * @Modified By:
 */
public class UserRepository {
  private Collection<User> users;

  /** spring内建的非bean对象.*/
  private BeanFactory beanFactory;

  private ObjectFactory<User> userObjectFactory;

  private ObjectFactory<ApplicationContext> objectFactory;

  public Collection<User> getUsers() {
    return users;
  }

  public void setUsers(
      Collection<User> users) {
    this.users = users;
  }

  public ObjectFactory<User> getUserObjectFactory() {
    return userObjectFactory;
  }

  public void setUserObjectFactory(
      ObjectFactory<User> userObjectFactory) {
    this.userObjectFactory = userObjectFactory;
  }

  public ObjectFactory<ApplicationContext> getObjectFactory() {
    return objectFactory;
  }

  public void setObjectFactory(
      ObjectFactory<ApplicationContext> objectFactory) {
    this.objectFactory = objectFactory;
  }

  public BeanFactory getBeanFactory() {
    return beanFactory;
  }

  public void setBeanFactory(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }
}
