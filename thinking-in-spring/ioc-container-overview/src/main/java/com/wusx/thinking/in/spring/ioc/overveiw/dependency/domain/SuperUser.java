package com.wusx.thinking.in.spring.ioc.overveiw.dependency.domain;

import com.wusx.thinking.in.spring.ioc.overveiw.dependency.annotation.Super;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 19:09 2020/3/29.
 * @Modified By:
 */
@Super
public class SuperUser extends User {

  private String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "SuperUser{" +
        "address='" + address + '\'' +
        "} " + super.toString();
  }
}
