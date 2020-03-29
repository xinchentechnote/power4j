package com.wsx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum.
 *
 * @Description .
 * @Author: Shangxiu Wu
 * @Date: 11:09 2020/3/28.
 * @Modified By:
 */
public class Question1 {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = target - nums[i];
      if (map.containsKey(key)) {
        return new int[]{map.get(key), i};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[]{0};
  }
}
