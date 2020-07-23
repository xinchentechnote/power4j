package com.wsx.sort;

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
    BubbleSort.sort(nums);
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
  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      boolean sorted = true;
      for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
          sorted = false;
        }
      }
      if (sorted) {
        break;
      }
    }
  }
}
