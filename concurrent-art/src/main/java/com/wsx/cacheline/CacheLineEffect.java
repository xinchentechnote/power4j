package com.wsx.cacheline;

/**
 * 高性能队列——Disruptor
 * https://tech.meituan.com/2016/11/18/disruptor.html
 */
public class CacheLineEffect {

  //考虑一般缓存行大小是64字节，一个 long 类型占8字节
  static long[][] arr;
  static int count = 4094;

  public static void main(String[] args) {
    arr = new long[count * count][];
    for (int i = 0; i < count * count; i++) {
      arr[i] = new long[8];
      for (int j = 0; j < 8; j++) {
        arr[i][j] = 0L;
      }
    }
    long sum = 0L;
    long marked = System.currentTimeMillis();
    for (int i = 0; i < count * count; i += 1) {
      for (int j = 0; j < 8; j++) {
        sum = arr[i][j];
      }
    }
    System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");

    marked = System.currentTimeMillis();
    for (int i = 0; i < 8; i += 1) {
      for (int j = 0; j < count * count; j++) {
        sum = arr[j][i];
      }
    }
    System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");
  }
}
