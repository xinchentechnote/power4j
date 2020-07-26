package com.wsx.sort;

import java.util.Arrays;

/**
 * @Description 选择排序.
 * @Author:ShangxiuWu
 * @Date: 10:55 2020/7/23.
 * @Modified By:
 */
public class SelectionSort {

  public static void main(String[] args) {

    int[] nums = {83, 2, 8, 4, 1};
    SelectionSort.sort(nums);
    System.out.println(Arrays.toString(nums));

  }

  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      System.out.println(Arrays.toString(nums));
      int minimumIndex = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[minimumIndex] > nums[j]) {
          minimumIndex = j;
        }
      }
      int temp = nums[i];
      nums[i] = nums[minimumIndex];
      nums[minimumIndex] = temp;
    }
  }


}
