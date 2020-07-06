package com.wsx.leetcode.editor.en;

//Given a sorted array nums, remove the duplicates in-place such that duplicates
// appeared at most twice and return the new length. 
//
// Do not allocate extra space for another array, you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Example 1: 
//
// 
//Given nums = [1,1,1,2,2,3],
//
//Your function should return length = 5, with the first five elements of nums b
//eing 1, 1, 2, 2 and 3 respectively.
//
//It doesn't matter what you leave beyond the returned length. 
//
// Example 2: 
//
// 
//Given nums = [0,0,1,1,1,1,2,3,3],
//
//Your function should return length = 7, with the first seven elements of nums 
//being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
//
//It doesn't matter what values are set beyond the returned length.
// 
//
// Clarification: 
//
// Confused why the returned value is an integer but your answer is an array? 
//
// Note that the input array is passed in by reference, which means modification
// to the input array will be known to the caller as well. 
//
// Internally you can think of this: 
//
// 
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
//s.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics Array Two Pointers 
// 👍 1141 👎 696


//Java：Remove Duplicates from Sorted Array II
public class Q80RemoveDuplicatesFromSortedArrayIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
}
//leetcode submit region end(Prohibit modification and deletion)

}