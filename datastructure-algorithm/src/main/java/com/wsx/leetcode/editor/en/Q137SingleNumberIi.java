package com.wsx.leetcode.editor.en;

//Given a non-empty array of integers, every element appears three times except 
//for one, which appears exactly once. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement i
//t without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,3,2]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [0,1,0,1,0,1,99]
//Output: 99 
// Related Topics Bit Manipulation 
// 👍 1793 👎 351


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Java：Single Number II
public class Q137SingleNumberIi{
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
                map.put(num,map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> entries = map.keySet();
        for (Integer entry : entries) {
            if (map.get(entry)==1){
                return entry;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}