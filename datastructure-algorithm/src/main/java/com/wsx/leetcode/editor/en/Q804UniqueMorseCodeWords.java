package com.wsx.leetcode.editor.en;

//International Morse Code defines a standard encoding where each letter is mapp
//ed to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-.
//..", "c" maps to "-.-.", and so on. 
//
// For convenience, the full table for the 26 letters of the English alphabet is
// given below: 
//
// 
//[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--
//","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.
//."] 
//
// Now, given a list of words, each word can be written as a concatenation of th
//e Morse code of each letter. For example, "cab" can be written as "-.-..--...", 
//(which is the concatenation "-.-." + ".-" + "-..."). We'll call such a concatena
//tion, the transformation of a word. 
//
// Return the number of different transformations among all words we have. 
//
// 
//Example:
//Input: words = ["gin", "zen", "gig", "msg"]
//Output: 2
//Explanation: 
//The transformation of each word is:
//"gin" -> "--...-."
//"zen" -> "--...-."
//"gig" -> "--...--."
//"msg" -> "--...--."
//
//There are 2 different transformations, "--...-." and "--...--.".
// 
//
// Note: 
//
// 
// The length of words will be at most 100. 
// Each words[i] will have length in range [1, 12]. 
// words[i] will only consist of lowercase letters. 
// 
// Related Topics String 
// 👍 614 👎 637


import java.util.TreeSet;

//Java：Unique Morse Code Words
public class Q804UniqueMorseCodeWords{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] data = {"hello", "world"};
        // TO TEST
        System.out.println(solution.uniqueMorseRepresentations(data));
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)

}