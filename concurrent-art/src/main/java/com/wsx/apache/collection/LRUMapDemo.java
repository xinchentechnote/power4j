package com.wsx.apache.collection;

import org.apache.commons.collections4.map.LRUMap;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 17:49 2020/5/13.
 * @Modified By:
 */
public class LRUMapDemo {

  public static void main(String[] args) {
    LRUMap<String, Integer> lruMap = new LRUMap<>(3);
    lruMap.put("1", 1);
    lruMap.put("2", 2);
    lruMap.put("3", 3);
    lruMap.put("4", 4);
    lruMap.put("5", 5);
    System.out.println(lruMap);//{3=3, 4=4, 5=5}
  }
}
