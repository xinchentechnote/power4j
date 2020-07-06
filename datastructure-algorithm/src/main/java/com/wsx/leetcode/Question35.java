package com.wsx.leetcode;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 10:05 2020/7/6.
 * @Modified By:
 */
public class Question35 {

  public static void main(String[] args) {
    int[] data = new int[]{1, 3, 5, 6};
    Solution solution = new Solution();
    System.out.println(solution.searchInsert(data, 2));
  }


  static class Solution {

    public int searchInsert(int[] nums, int target) {
      return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int searchInsert(int[] nums, int target, int left, int right) {
      if (left >= right && target != nums[left]) {//查找不到的情况
        if (target > nums[right])//如果比查找的当前数字大，返回为当前数字索引+1
        {
          return right + 1;
        } else//查找的数字比当前数字小，返货为当前数字索引
        {
          return right;
        }
      }

      //二分搜索
      int mid = (left + right) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (target > nums[mid]) {
        return searchInsert(nums, target, mid + 1, right);
      } else {
        return searchInsert(nums, target, left, mid - 1);
      }

    }
  }

}
