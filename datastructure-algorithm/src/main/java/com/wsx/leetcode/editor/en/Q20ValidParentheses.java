package com.wsx.leetcode.editor.en;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
// Related Topics String Stack 
// 👍 5020 👎 217


import com.wsx.play.datastructure.ArrayStack;
import java.util.Stack;

//Java：Valid Parentheses
public class Q20ValidParentheses{
    public static void main(String[] args) {
        String data = "()[]{}";
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.isValid(data));
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)

}