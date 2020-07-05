package com.wsx.play.datastructure.map;

import lombok.NoArgsConstructor;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 19:58 2020/7/5.
 * @Modified By:
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

  private Node root;
  private int size;

  private class Node {

    public K key;
    public V value;
    public Node left;
    public Node right;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
    }

  }


  @Override
  public void add(K key, V value) {
    add(root, key, value);
  }

  private Node add(Node node, K key, V value) {
    if (null == node) {
      size++;
      return new Node(key, value);
    } else {
      if (key.compareTo(node.key) > 0) {
        return add(node.right, key, value);
      } else if (key.compareTo(node.key) < 0) {
        return add(node.left, key, value);
      } else {
        node.value = value;
      }
    }
    return node;
  }

  @Override
  public V remove(K key) {
    return null;
  }

  @Override
  public boolean contains(K key) {
    return false;
  }

  @Override
  public V get(K key) {
    return null;
  }

  @Override
  public void set(K key, V value) {

  }

  @Override
  public int getSize() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
