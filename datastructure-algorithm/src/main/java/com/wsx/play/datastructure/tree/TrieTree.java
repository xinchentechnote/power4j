package com.wsx.play.datastructure.tree;

import java.util.Map;
import java.util.TreeMap;

/**.
 * @Description Trie字典树、前缀树.
 * @Author:ShangxiuWu
 * @Date: 23:30 2020/7/6.
 * @Modified By:
 */
public class TrieTree {

  private Node root;

  private int size;

  public TrieTree() {
    root = new Node();
    this.size = 0;
  }

  public int getSize() {
    return this.size;
  }

  public void add(String word) {
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
      size++;
    }
  }

  public boolean contains(String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!cur.next.containsKey(c)) {
        return false;
      }
      cur = cur.next.get(c);
    }
    return cur.isWord;
  }

  public boolean isPrefix(String prefix) {
    Node cur = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (!cur.next.containsKey(c)) {
        return false;
      }
      cur = cur.next.get(c);
    }
    return true;
  }

  /**
   * T
   * rieTree节点.
   * @Description
   * @Author:ShangxiuWu
   * @Date: 20:05 2020/7/11.
   * @Modified By:
   */
  private class Node {

    boolean isWord;
    Map<Character, Node> next;

    public Node() {
      this(false);
    }

    public Node(boolean isWord) {
      this.isWord = isWord;
      this.next = new TreeMap<>();
    }
  }

  public static void main(String[] args) {
    TrieTree tree = new TrieTree();
    tree.add("hello");
    tree.add("word");
    tree.add("suptc");
    System.out.println(tree.contains("hello"));
    System.out.println(tree.contains("wsx"));
  }

}
