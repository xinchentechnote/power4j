package com.wsx.leetcode.editor.en;

//Given an integer array nums, find the sum of the elements between indices i an
//d j (i ≤ j), inclusive. 
//
// The update(i, val) function modifies nums by updating the element at index i 
//to val. 
//
// Example: 
//
// 
//Given nums = [1, 3, 5]
//
//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
// 
//
// Note: 
//
// 
// The array is only modifiable by the update function. 
// You may assume the number of calls to update and sumRange function is distrib
//uted evenly. 
// 
// Related Topics Binary Indexed Tree Segment Tree 
// 👍 1281 👎 81


//Java：Range Sum Query - Mutable
public class Q307RangeSumQueryMutable {

  public static void main(String[] args) {
    int[] data = new int[]{1, 3, 5};
    NumArray solution = new NumArray(data);
    // TO TEST
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class NumArray {

    public NumArray(int[] nums) {

    }

    public void update(int i, int val) {

    }

    public int sumRange(int i, int j) {
      return 0;
    }
  }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)

}