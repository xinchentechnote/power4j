package com.wsx.gupao;

import java.util.ArrayList;
import java.util.List;

/**
 * 编号1-2017的智能灯，中控可以发指令切换灯的亮灭状态，
 * 初始状态全部是灭的，从1数到2017，每数到一个数，
 * 把编号能被改数整除的灯的状态切换一下，问数完2017后，
 * 还有几盏灯是亮的
 * 比如，数到1，所有的灯切换，就是全部亮灯，数到2，就是偶数的灯切换，
 * 就只剩下基数的灯亮着，数到3...
 *
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 19:48 2020/7/13.
 * @Modified By:
 */
public class Question4 {

  public static void main(String[] args) {
    int count = 2017;
    IntMap map = new IntMap(count);
    for (int i = 1; i <= count; i++) {
      for (int j = 1; j < count; j++) {
        if (j % i == 0) {
          map.not(j);
        }
      }
    }
    System.out.println(map.oneList().size());
    System.out.println(map.oneList());
  }

  static class IntMap {

    int[] data;

    public IntMap(int capacity) {
      data = new int[capacity + 1];
    }

    public int not(int index) {
      data[index] = data[index] == 0 ? 1 : 0;
      return data[index];
    }

    public int setOne(int index) {
      data[index] = 1;
      return data[index];
    }

    public int setZero(int index) {
      data[index] = 0;
      return data[index];
    }

    public List<Integer> oneList() {
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < data.length; i++) {
        if (data[i] == 1) {
          list.add(i);
        }
      }
      return list;
    }

  }

}
