package com.wsx.math;

/**.
 * @Author:wusx
 * @Date: Created in 18:58 2020/4/7 0007.
 * @Description
 * 给定 x, k ，求满足 x + y = x | y 的第 k 小的正整数 y 。
 * | 是二进制的或(or)运算，例如 3 | 5 = 7。
 * 比如当 x=5，k=1时返回 2，因为5+1=6 不等于 5|1=5，而 5+2=7 等于 5 | 2 = 7。.
 * @Modified By:
 */
public class Question1 {

  public static void main(String[] args) {
    System.out.println(cal(5, 3));
  }

  public static int cal(int x, int k) {
    int y = 0;
    int count = 0;
    while (count < k) {
      y++;
      if ((y & x) == 0) {
        count++;
      }
    }
    return y;
  }
}
