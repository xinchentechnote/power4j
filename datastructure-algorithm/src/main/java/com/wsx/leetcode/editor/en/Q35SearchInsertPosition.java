package com.wsx.leetcode.editor.en;

//Given a sorted array and a target value, return the index if the target is fou
//nd. If not, return the index where it would be if it were inserted in order. 
//
// You may assume no duplicates in the array. 
//
// Example 1: 
//
// 
//Input: [1,3,5,6], 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [1,3,5,6], 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: [1,3,5,6], 7
//Output: 4
// 
//
// Example 4: 
//
// 
//Input: [1,3,5,6], 0
//Output: 0
// 
// Related Topics Array Binary Search 
// 👍 2390 👎 252

//Java：Search Insert Position
public class Q35SearchInsertPosition{
    public static void main(String[] args) {
      int[] data = new int[]{1, 3, 5, 6};
      Solution solution = new Solution();
      System.out.println(solution.searchInsert(data, 2));
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums[nums.length - 1] < target) {
                return nums.length;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) {
                    return i;
                }
            }
            return -1;
        }

        public int searchInsert1(int[] nums, int target) {
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
//leetcode submit region end(Prohibit modification and deletion)
}

