package com.wsx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description Intersection（交集） of Two Arrays II.
 * @Author:ShangxiuWu
 * @Date: 22:58 2020/7/5.
 * @Modified By:
 */
public class Question350 {

  public static void main(String[] args) {
    int[] array1 = new int[]{4, 4, 9, 5};
    int[] array2 = new int[]{9, 4, 9, 8, 4};
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.intersection(array1, array2)));

  }

  static class Solution {

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
}
