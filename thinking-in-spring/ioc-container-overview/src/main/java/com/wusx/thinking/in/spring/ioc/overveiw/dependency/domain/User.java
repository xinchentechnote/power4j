package com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 18:50 2020/3/29.
 * @Modified By:
 */
public class User {

  private Long id;
  private String name;

  public static User createUser() {

    User user = new User();
    user.setId(1000L);
    user.setName("static method");
    return user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
