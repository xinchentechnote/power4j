package com.wsx.hutool;

import cn.hutool.core.util.HashUtil;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 11:34 2020/5/14.
 * @Modified By:
 */
public class HashUtilDemo {

  public static void main(String[] args) {

    String content = "hello";
    System.out.println(HashUtil.apHash(content));
    System.out.println(HashUtil.bkdrHash(content));
  }
}
