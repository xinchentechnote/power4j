package com.wsx.gupao;

/**
 * 编号1-2017的智能灯，中控可以发指令切换灯的亮灭状态，
 * 初始状态全部是灭的，从1数到2017，每数到一个数，
 * 把编号能被改数整除的灯的状态切换一下，问数完2017后，
 * 还有几盏灯是亮的
 * 比如，数到1，所有的灯切换，就是全部亮灯，数到2，就是偶数的灯切换，
 * 就只剩下基数的灯亮着，数到3...
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 20:09 2020/7/13.
 * @Modified By:
 */
public class LampControl {


  static class BitMap {

    private byte[] data;

    public BitMap(int limit) {
      data = new byte[limit / 8 + 1];
    }

    /**
     * @Description 置1.
     * @Author:wusx
     * @Date 20:11 2020/7/13
     * @Modified
     */
    public void setOne(int index) {
      int byteIndex = index / 8;
      int bitIndex = index % 8;
      data[byteIndex] |= 1 << (7 - bitIndex);
    }

    /**
     * @Description 置0.
     * @Author:wusx
     * @Date 20:20 2020/7/13
     * @Modified
     */
    public void setZero(int index) {
      int byteIndex = index / 8;
      int bitIndex = index % 8;
      data[byteIndex] &= (~(1 << (7 - bitIndex)));
    }

    /**
     * @Description 取反.
     * @Author:wusx
     * @Date 20:28 2020/7/13
     * @Modified
     */
    public void invert(int index) {
      int byteIndex = index / 8;
      int bitIndex = index % 8;
      data[byteIndex] ^= (1 << (7 - bitIndex));
    }

    /**
     * @Description 判断是否为1.
     * @Author:wusx
     * @Date 20:20 2020/7/13
     * @Modified
     */
    public boolean isOne(int index) {
      int byteIndex = index / 8;
      int bitIndex = index % 8;
      return (data[byteIndex] & (1 << (7 - bitIndex))) != 0;
    }

    public int countOne() {
      int count = 0;
      for (int i = 0; i < data.length; i++) {
        byte datum = data[i];
        for (int j = 0; j < 8; j++) {
          if ((datum & (1 << (7 - j))) != 0) {
            count++;
          }
        }
      }
      return count;
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

  public static void main(String[] args) {
    BitMap map = new BitMap(7);
    System.out.println(map.toString());
    map.invert(1);
    map.invert(2);
    map.invert(2);
    map.invert(3);
    map.invert(4);
    System.out.println(map.toString());
    map.print();
    System.out.println(map.countOne());
    System.out.println("----------------------------");
    int count = 2018;
    BitMap bitMap = new BitMap(count);
    for (int i = 1; i < count; i++) {
      for (int j = 1; j < count; j++) {
        if (j % i == 0) {
          bitMap.invert(j);
        }
      }
    }
    System.out.println("total:"+bitMap.countOne());
    System.out.println(bitMap.toString());
  }
}
