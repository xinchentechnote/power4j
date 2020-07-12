package com.wsx.leetcode.editor.en;

//Given a string, find the first non-repeating character in it and return its in
//dex. If it doesn't exist, return -1. 
//
// Examples: 
//
// 
//s = "leetcode"
//return 0.
//
//s = "loveleetcode"
//return 2.
// 
//
// 
//
// Note: You may assume the string contains only lowercase English letters. 
// Related Topics Hash Table String 
// 👍 1929 👎 116


import java.util.HashMap;
import java.util.Map;

//Java：First Unique Character in a String
public class Q387FirstUniqueCharacterInAString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar1("leetcode"));
        System.out.println(solution.firstUniqChar2("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
        System.out.println(solution.firstUniqChar1("loveleetcode"));
        System.out.println(solution.firstUniqChar2("loveleetcode"));
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c: chars){
            if (!map.containsKey(c)) {
                map.put(c,1);
            }else {
                map.put(c,map.get(c)+1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] hashtable = new int[26];
        char[] chars = s.toCharArray();
        for (char c: chars){
            hashtable[c-'a']+=1;
        }
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (hashtable[index]==1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar(String s) {
        byte[] hashtable = new byte[26];
        char[] chars = s.toCharArray();
        for (char c: chars){
            if (hashtable[c-'a']<2) {
                hashtable[c - 'a'] += 1;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (hashtable[index]==1){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}