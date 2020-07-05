package com.wsx.play.datastructure.map;

import com.google.common.base.Stopwatch;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:49 2020/7/5.
 * @Modified By:
 */
public class MapTest {

  public static void main(String[] args) {
    test(new BSTMap<>());
    test(new LinkedListMap<>());
  }

  private static void test(Map<String, Integer> map) {
    Stopwatch stopwatch = Stopwatch.createStarted();
    for (int i = 0; i < 10_000; i++) {
      map.add("key" + i, i);
    }
    System.out.println(stopwatch.stop().toString());
  }

}
