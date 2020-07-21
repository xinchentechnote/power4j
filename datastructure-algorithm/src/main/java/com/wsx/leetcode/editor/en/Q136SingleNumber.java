package com.wsx.leetcode.editor.en;

//Given a non-empty array of integers, every element appears twice except for on
//e. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,1]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,1,2,1,2]
//Output: 4
// 
// Related Topics Hash Table Bit Manipulation 
// 👍 4521 👎 162


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//Java：Single Number
public class Q136SingleNumber {

  public static void main(String[] args) {
    Solution solution = new Solution();
    // TO TEST
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int singleNumber(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        if (map.containsKey(num)) {
          map.remove(num);
        } else {
          map.put(num, 1);
        }
      }
      Set<Integer> entries = map.keySet();
      for (Integer entry : entries) {
        return entry;
      }
      return 0;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}