package com.wsx.mrhan.sort;

import java.util.Arrays;

/**
 * @Description 冒泡排序.
 * @Author:ShangxiuWu
 * @Date: 10:18 2020/5/13.
 * @Modified By:
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] nums = new int[]{3, 5, 8, 2, -3, 10, -6};
    System.out.println(Arrays.toString(nums));
    //Arrays.sort(nums);//jdk的内部实现
    sort(nums);
    System.out.println(Arrays.toString(nums));
  }

  /**
   *@Description 冒泡排序.
   *@params
   *@return
   *@Author wusx
   *@Date 10:39 2020/5/13
   *@Modified
   */
  private static void sort(int[] nums) {

  }
}
