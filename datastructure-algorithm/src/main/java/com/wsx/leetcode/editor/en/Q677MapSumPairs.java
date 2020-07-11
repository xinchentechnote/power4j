package com.wsx.leetcode.editor.en;

//
//Implement a MapSum class with insert, and sum methods.
// 
//
// 
//For the method insert, you'll be given a pair of (string, integer). The string
// represents the key and the integer represents the value. If the key already exi
//sted, then the original key-value pair will be overridden to the new one.
// 
//
// 
//For the method sum, you'll be given a string representing the prefix, and you 
//need to return the sum of all the pairs' value whose key starts with the prefix.
//
// 
//
// Example 1: 
// 
//Input: insert("apple", 3), Output: Null
//Input: sum("ap"), Output: 3
//Input: insert("app", 2), Output: Null
//Input: sum("ap"), Output: 5
// 
// 
// Related Topics Trie 
// 👍 479 👎 81


import java.util.Map;
import java.util.TreeMap;
import javax.swing.text.DefaultEditorKit.CutAction;

//Java：Map Sum Pairs
public class Q677MapSumPairs{
    public static void main(String[] args) {
        MapSum solution = new MapSum();
        // TO TEST
        solution.insert("apple",3);
        System.out.println(solution.sum("ap"));
        solution.insert("app",2);
        System.out.println(solution.sum("ap"));
    }
static
    //leetcode submit region begin(Prohibit modification and deletion)
class MapSum {

    private class Node{
        private int value;
        private Map<Character,Node> next;

        public Node() {
            this.value = 0;
            this.next = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node cur) {
        if (cur.next.size()==0){
            return cur.value;
        }
        int result = cur.value;
        for (char nextChar:cur.next.keySet()){
            result+=sum(cur.next.get(nextChar));
        }
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}