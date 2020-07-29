package com.wsx.leetcode.editor.en;

//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Example 1: 
//
// 
//Input: 123
//Output: 321
// 
//
// Example 2: 
//
// 
//Input: -123
//Output: -321
// 
//
// Example 3: 
//
// 
//Input: 120
//Output: 21
// 
//
// Note: 
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows. 
// Related Topics Math 
// 👍 3467 👎 5475


import java.util.LinkedList;
import java.util.Queue;

//Java：Reverse Integer
public class Q7ReverseInteger {

  public static void main(String[] args) {
    Solution solution = new Solution();
    // TO TEST
    System.out.println(solution.reverse(-321));
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int reverse(int x) {
      boolean symbol = x < 0;
      //boolean symbol = (x & 0x80_00_00_00) == 0x80_00_00_00;
      int usignX = Math.abs(x);
      int i = 0;
      Queue<Integer> queue = new LinkedList<>();
      while ((usignX / pow(10, i)) != 0) {
        int mode = (usignX % pow(10, i + 1) / pow(10, i));
        queue.add(mode);
        i++;
      }
      int result = 0;
      for (int j = queue.size() - 1; j >= 0; j--) {
        Integer remove = queue.remove();
        result += remove * pow(10, j);
      }
      return symbol ? 0 - result : result;
    }

    private int pow(int a, int b) {
      if (b == 0) {
        return 1;
      }
      for (int i = 1; i < b; i++) {
        a *= a;
      }
      return a;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}