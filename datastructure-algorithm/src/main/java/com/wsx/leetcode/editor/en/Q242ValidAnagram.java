package com.wsx.leetcode.editor.en;

//Given two strings s and t , write a function to determine if t is an anagram o
//f s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your soluti
//on to such case? 
// Related Topics Hash Table Sort 
// 👍 1513 👎 140


//Java：Valid Anagram
public class Q242ValidAnagram {

  public static void main(String[] args) {
    Solution solution = new Solution();
    // TO TEST
    System.out.println(solution.isAnagram("anagraa", "nagaram"));
    System.out.println(solution.isAnagram("anagram", "nagaram"));
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      char[] counts = new char[26];
      for (int i = 0; i < s.length(); i++) {
        counts[s.charAt(i) - 'a'] += 1;
      }
      for (int i = 0; i < t.length(); i++) {
        char count = counts[t.charAt(i) - 'a'];
        if (count == 0) {
          return false;
        } else if (count > 0) {
          counts[t.charAt(i) - 'a'] -= 1;
        }
      }
      return true;
    }

    public boolean isAnagram1(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }
      int[] counts = new int[26];
      for (int i = 0; i < s.length(); i++) {
        counts[s.charAt(i) - 'a'] += 1;
      }
      for (int i = 0; i < t.length(); i++) {
        int count = counts[t.charAt(i) - 'a'];
        if (count == 0) {
          return false;
        } else if (count > 0) {
          counts[t.charAt(i) - 'a'] -= 1;
        }
      }
      return true;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}