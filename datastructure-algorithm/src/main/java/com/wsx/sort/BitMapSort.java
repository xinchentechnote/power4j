package com.wsx.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Description 100m的文件，都是不重复的8位数字，使用20m内存进行排序.输出到另外一个文件.
 * @Author:ShangxiuWu
 * @Date: 15:36 2020/7/4.
 * @Modified By:
 */
public class BitMapSort {

  public static void main(String[] args) throws FileNotFoundException {
    Container container = new Container(99_999_999);
    File source = new File(
        "datastructure-algorithm/src/main/resourse/data.text");
    System.out.println(source.getAbsolutePath());
    Scanner scanner = new Scanner(source);
    while (scanner.hasNext()) {
      int element = scanner.nextInt();
      System.out.println(element);
      container.add(element);
    }
    System.out.println("-----------");
    container.print();
    System.out.println("-----------");
    System.out.println(container.byteLength());
  }

  static class Container {

    private byte[] data;

    public Container(int limit) {
      data = new byte[limit / 8 + 1];
    }

    public void add(int element) {
      int byteIndex = element / 8;
      int bitIndex = element % 8;
      data[byteIndex] |= 1 << (7 - bitIndex);
    }

    public void clear(int element) {
      int byteIndex = element / 8;
      int bitIndex = element % 8;
      data[byteIndex] &= (~(1 << (7 - bitIndex)));
    }

    public boolean container(int element) {
      int byteIndex = element / 8;
      int bitIndex = element % 8;
      return (data[byteIndex] & (1 << (7 - bitIndex))) != 0;
    }

    public void print() {
      for (int i = 0; i < data.length; i++) {
        byte datum = data[i];
        for (int j = 0; j < 8; j++) {
          if ((datum & (1 << (7 - j))) != 0) {
            System.out.println(8 * i + j);
          }
        }
      }
    }

    public int byteLength() {
      return data.length;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < data.length; i++) {
        String binaryString = Integer.toBinaryString(data[i]);
        builder.append(binaryString).append("\n");
      }
      return builder.toString();
    }
  }
}
