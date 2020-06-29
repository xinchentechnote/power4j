package com.wsx.play.datastructure;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午5:58 2020/6/29.
 * @Modified By:
 */
public class Sum {
  /**
   *@Description 递归函数的微观解读.
   * 《玩转数据结构》
   *@Author  wusx
   *@Date 下午7:28 2020/6/29
   *@Modified
   */
  public static void main(String[] args) {
    int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(sum(data));
  }

  public static int sum(int[] arr) {
    return sum(arr, 0);
  }

  public static int sum(int[] arr, int l) {
    //递归终止条件
    //求解最基本的问题
    if (arr.length == l) {
      return 0;
    }
    //把原问题转化为子问题
    return arr[l] + sum(arr, l + 1);
  }

}
