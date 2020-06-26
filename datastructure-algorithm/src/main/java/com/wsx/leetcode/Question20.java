package com.wsx.leetcode;


import java.util.Stack;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 上午12:06 2020/6/27.
 * @Modified By:
 */
public class Question20 {

  static String data = "()[]{}";

  public static void main(String[] args) {
    Question20 question20 = new Question20();
    System.out.println(question20.isValid(data));
  }

  public boolean isValid(String data) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < data.length(); i++) {
      char c = data.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (stack.empty()) {
          return false;
        } else if (c == ')' && stack.pop() != '(') {
          return false;
        } else if (c == ']' && stack.pop() != '[') {
          return false;
        } else if (c == '}' && stack.pop() != '{') {
          return false;
        }
      }
    }
    return stack.empty();
  }

}
