package com.wusx.thinking.in.spring.bean.factory;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain.User;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:56 2020/3/29.
 * @Modified By:
 */
public interface UserFactory {

  default User createUser() {
    User user = new User();
    user.setName("factory");
    user.setId(20000L);
    return user;
  }

}
