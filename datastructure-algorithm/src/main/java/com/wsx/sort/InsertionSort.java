package com.wsx.sort;

import java.util.Arrays;

/**
 * @Description 插入排序.
 * @Author:ShangxiuWu
 * @Date: 10:55 2020/7/23.
 * @Modified By:
 */
public class InsertionSort {

  public static void main(String[] args) {

    int[] nums = {83, 2, 8, 4, 1};
    InsertionSort.sort(nums);
    System.out.println(Arrays.toString(nums));

  }

  public static void sort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      System.out.println(Arrays.toString(nums));
      for (int j = i; j > 0; j--) {
        if (nums[j] > nums[j - 1]) {
          int temp = nums[j];
          nums[j] = nums[j - 1];
          nums[j - 1] = temp;
        }
      }
    }
  }


}
