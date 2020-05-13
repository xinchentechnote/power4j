package com.wsx.apache.collection;

import org.apache.commons.collections4.map.SingletonMap;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 18:56 2020/5/13.
 * @Modified By:
 */
public class SingletonMapDemo {

  public static void main(String[] args) {
    SingletonMap<String,String> singletonMap = new SingletonMap<>();
    singletonMap.put("key","value");
  }
}
