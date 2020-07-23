package com.wsx.sort;

import java.util.Arrays;

/**
 * @Description 冒泡排序.
 * @Author:ShangxiuWu
 * @Date: 10:11 2020/7/23.
 * @Modified By:
 */
public class BubblingSort {

  public static void main(String[] args) {
    int[] nums = new int[]{8, 7, 6, 5, 4, 3};
    BubblingSort.sort(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void sort(int[] nums) {
    for (int j = 0; j < nums.length - 1; j++) {
      System.out.println(Arrays.toString(nums));
      boolean sorted = true;
      for (int i = 1; i < nums.length - j; i++) {
        if (nums[i] > nums[i - 1]) {
          int temp = nums[i];
          nums[i] = nums[i - 1];
          nums[i - 1] = temp;
          sorted = false;
        }
      }
      System.out.println(j);
      if (sorted) {
        break;
      }
    }
  }

}
