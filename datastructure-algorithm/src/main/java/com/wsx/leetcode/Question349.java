package com.wsx.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:58 2020/7/5.
 * @Modified By:
 */
public class Question349 {

  public static void main(String[] args) {
    int[] array1 = new int[]{4, 9, 5};
    int[] array2 = new int[]{9, 4, 9, 8, 4};
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.intersection(array1, array2)));

  }

  static class Solution {

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
}
