package com.wusx.ioc.java.beans;

/**
 * @Description POJO 贫血模型getter和setter.
 * 可读可写，property
 * @Author:ShangxiuWu
 * @Date: 16:11 2020/3/29.
 * @Modified By:
 */
public class Person {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
