package com.wsx.leetcode.editor.en;

//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9] 
// 
//
// Note: 
//
// 
// Each element in the result should appear as many times as it shows in both ar
//rays. 
// The result can be in any order. 
// 
//
// Follow up: 
//
// 
// What if the given array is already sorted? How would you optimize your algori
//thm? 
// What if nums1's size is small compared to nums2's size? Which algorithm is be
//tter? 
// What if elements of nums2 are stored on disk, and the memory is limited such 
//that you cannot load all elements into the memory at once? 
// 
// Related Topics Hash Table Two Pointers Binary Search Sort 
// 👍 1358 👎 404


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Java：Intersection of Two Arrays II
public class Q350IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                if (map.get(nums2[i]) == 0) {
                    map.remove(nums2[i]);
                }
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