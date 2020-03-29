package com.wsx.leetcode;


/**
 * @Description 80. Remove Duplicates from Sorted Array II.
 * @Author:ShangxiuWu
 * @Date: 20:04 2020/3/28.
 * @Modified By:
 */
public class Question80 {

  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int index = 0;
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[index] != nums[i]) {
        nums[++index] = nums[i];
        count = 0;
      } else if (count++ == 0) {
        nums[++index] = nums[i];
      }
    }
    return index + 1;
  }

  public int removeDuplicates2(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int index = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] != nums[index - 2]) {
        nums[index++] = nums[i];
      }
    }
    return index;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.out.println(new Question80().removeDuplicates(nums));
  }

}
