package com.wsx.play.datastructure.map;


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
    root = add(root, key, value);
  }

  private Node add(Node node, K key, V value) {
    if (null == node) {
      size++;
      return new Node(key, value);
    } else {
      if (key.compareTo(node.key) > 0) {
        node.right = add(node.right, key, value);
      } else if (key.compareTo(node.key) < 0) {
        node.left = add(node.left, key, value);
      } else {
        node.value = value;
      }
    }
    return node;
  }

  private Node getNode(Node node, K key) {
    if (null == node) {
      return null;
    }
    if (key.compareTo(node.key) == 0) {
      return node.right;
    } else if (key.compareTo(node.key) > 0) {
      return getNode(node.right, key);
    } else {
      return getNode(node.left, key);
    }
  }

  @Override
  public V remove(K key) {
    Node node = getNode(root, key);
    if (null == node) {
      return null;
    }
    root = removeNode(root, key);
    return node.value;
  }

  private Node removeNode(Node node, K key) {
    if (key.compareTo(node.key) < 0) {
      return removeNode(node.left, key);
    } else if (key.compareTo(node.key) > 0) {
      return removeNode(node.right, key);
    } else {
      if (null == node.left) {
        Node right = node.right;
        node.right = null;
        size--;
        return right;
      }
      if (null == node.right) {
        Node left = node.left;
        node.left = null;
        size--;
        return left;
      }

      Node minimum = minimum(node.right);
      minimum.right = removeMin(node.right);
      minimum.left = node.left;
      node.left = node.right = null;
      return minimum;
    }
  }

  private Node minimum(Node node) {
    if (null != node.left) {
      return minimum(node.left);
    }
    return node;
  }

  private Node removeMin(Node node) {
    if (null == node.left) {
      Node right = node.right;
      node.right = null;
      size--;
      return right;
    }
    node.left = removeMin(node.left);
    return node;
  }

  @Override
  public boolean contains(K key) {
    return getNode(root, key) == null;
  }

  @Override
  public V get(K key) {
    Node node = getNode(root, key);
    return null == node ? null : node.value;
  }

  @Override
  public void set(K key, V value) {
    Node node = getNode(root, key);
    if (null != node) {
      node.value = value;
    } else {
      throw new IllegalArgumentException("key dosn't exist.");
    }
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  public static void main(String[] args) {

    BSTMap<String, Integer> map = new BSTMap<>();
    map.add("hello", 1);
    map.add("hello", 1);
    map.add("ap", 1);
    map.add("test", 1);
    map.add("world", 1);
    System.out.println(map);
    System.out.println(map.getSize());
    map.remove("test");
    System.out.println(map.getSize());
    System.out.println(map);
  }

}
