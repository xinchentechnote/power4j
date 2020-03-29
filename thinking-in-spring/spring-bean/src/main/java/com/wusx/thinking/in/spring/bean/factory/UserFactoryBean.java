package com.wusx.thinking.in.spring.bean.factory;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 23:08 2020/3/29.
 * @Modified By:
 */
public class UserFactoryBean implements FactoryBean<User> {

  @Override
  public User getObject() throws Exception {
    User user = new User();
    user.setName("UserFactoryBean");
    user.setId(30000L);
    return user;
  }

  @Override
  public Class<?> getObjectType() {
    return User.class;
  }
}
