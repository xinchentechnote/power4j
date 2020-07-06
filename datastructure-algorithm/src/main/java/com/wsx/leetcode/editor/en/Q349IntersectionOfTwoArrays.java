package com.wsx.leetcode.editor.en;

//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4] 
// 
//
// Note: 
//
// 
// Each element in the result must be unique. 
// The result can be in any order. 
// 
//
// 
// Related Topics Hash Table Two Pointers Binary Search Sort 
// 👍 819 👎 1214


import java.util.HashSet;
import java.util.Set;

//Java：Intersection of Two Arrays
public class Q349IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (Integer e : result) {
            resultArray[index++] = e;
        }
        return resultArray;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}