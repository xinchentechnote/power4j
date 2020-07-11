package com.wsx.leetcode.editor.en;

//Design a data structure that supports the following two operations: 
//
// 
//void addWord(word)
//bool search(word)
// 
//
// search(word) can search a literal word or a regular expression string contain
//ing only letters a-z or .. A . means it can represent any one letter. 
//
// Example: 
//
// 
//addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
// 
//
// Note: 
//You may assume that all words are consist of lowercase letters a-z. 
// Related Topics Backtracking Design Trie 
// 👍 1772 👎 89


import java.util.Map;
import java.util.TreeMap;

//Java：Add and Search Word - Data structure design
public class Q211AddAndSearchWordDataStructureDesign{
    public static void main(String[] args) {
        WordDictionary solution = new WordDictionary();
        // TO TEST
        solution.addWord("word");
        System.out.println(solution.search("w..d"));
        System.out.println(solution.search("word"));
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {

    private class Node{
        private boolean isWord;
        private Map<Character,Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, 0, word);
    }

    private boolean match(Node node,int index,String word) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if ( '.' != c ) {
            if (!node.next.containsKey(c)) {
                return false;
            } else {
                return match(node.next.get(c), index + 1, word);
            }
        }else{
            for (char nextChar:node.next.keySet()){
                if (match(node.next.get(nextChar),index+1,word)){
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}