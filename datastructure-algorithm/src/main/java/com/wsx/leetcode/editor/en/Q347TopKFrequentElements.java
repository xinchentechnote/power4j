package com.wsx.leetcode.editor.en;

//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is t
//he array's size. 
// It's guaranteed that the answer is unique, in other words the set of the top 
//k frequent elements is unique. 
// You can return the answer in any order. 
// 
// Related Topics Hash Table Heap 
// 👍 3051 👎 209


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

//Java：Top K Frequent Elements
public class Q347TopKFrequentElements {

  public static void main(String[] args) {
    Solution solution = new Solution();
//    int[] data = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3};
    int[] data = new int[]{1, 1, 2, 2, 3, 3, 3, 3};
    System.out.println(Arrays.toString(solution.topKFrequent(data, 2)));

  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public int[] topKFrequent(int[] nums, int k) {
      TreeMap<Integer, Integer> map = new TreeMap<>();
      for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
          map.put(nums[i], map.get(nums[i]) + 1);
        } else {
          map.put(nums[i], 1);
        }
      }
      PriorityQueue<Freq> queue = new PriorityQueue<>(k);
      for (Integer key : map.keySet()) {
        Freq freq = new Freq(key, map.get(key));
        if (queue.size() < k) {
          queue.add(freq);
        } else if (map.get(key) > queue.peek().freq) {
          queue.remove();
          queue.add(freq);
        }
      }
      int[] result = new int[k];
      int index = 0;
      while (!queue.isEmpty()) {
        result[index++] = queue.poll().num;
      }
      return result;

    }

    class Freq implements Comparable<Freq> {

      private int num;
      private int freq;

      public Freq(int num, int freq) {
        this.num = num;
        this.freq = freq;
      }

      @Override
      public int compareTo(Freq o) {
        if (this.freq == o.freq) {
          return 0;
        } else if (this.freq < o.freq) {
          return -1;
        } else {
          return 1;
        }
      }
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}