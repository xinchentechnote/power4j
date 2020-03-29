package com.wsx.leetcode;

/**
 * @Description 26. Remove Duplicates from Sorted Array.
 * @Author:ShangxiuWu
 * @Date: 19:45 2020/3/28.
 * @Modified By:
 */
public class Question26 {

  /**
   *@Description Given a sorted array nums, remove the duplicates in-place such that each
   * element appear only once and return the new length.
   * Do not allocate extra space for another array, you must do this
   * by modifying the input array in-place with O(1) extra memory..
   *@params
   *@return
   *@Author wusx
   *@Date 19:48 2020/3/28
   *@Modified
   */
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int index = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[index] != nums[i]) {
        nums[++index] = nums[i];
      }
    }
    return index + 1;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 1, 2, 2, 3, 3, 5, 9, 10};
    System.out.println(new Question26().removeDuplicates(nums));
  }

}
