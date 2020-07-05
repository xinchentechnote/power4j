package com.wsx.leetcode;


import java.util.TreeSet;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:38 2020/7/5.
 * @Modified By:
 */
public class Question804 {

  public static void main(String[] args) {
    String[] data = {"hello", "world"};
    Solution solution = new Solution();
    System.out.println(solution.uniqueMorseRepresentations(data));
  }

  static class Solution {

    private String[] mores = new String[]{
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
        "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
      TreeSet<String> set = new TreeSet<>();
      for (String word : words) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
          builder.append(mores[word.charAt(i) - 'a']);
        }
        set.add(builder.toString());
      }
      return set.size();
    }
  }
}
