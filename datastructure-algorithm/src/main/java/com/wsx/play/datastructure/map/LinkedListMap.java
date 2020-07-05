package com.wsx.play.datastructure.map;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 19:30 2020/7/5.
 * @Modified By:
 */
public class LinkedListMap<K, V> implements Map<K, V> {

  private Node dummyHead;
  private int size;

  public LinkedListMap() {
    this.dummyHead = new Node();
    this.size = 0;
  }

  private Node getNode(K key) {
    Node current = dummyHead.next;
    while (null != current) {
      if (key.equals(current.key)) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  @Override
  public void add(K key, V value) {
    Node node = getNode(key);
    if (null == node) {
      dummyHead.next = new Node(key, value, dummyHead.next);
      size++;
    } else {
      node.value = value;
    }
  }

  @Override
  public V remove(K key) {
    Node pre = dummyHead;
    while (null != pre.next) {
      if (key.equals(pre.next.key)) {
        Node target = pre.next;
        pre.next = target.next;
        target.next = null;
        size--;
        return target.value;
      } else {
        pre = pre.next;
      }
    }
    return null;
  }

  @Override
  public boolean contains(K key) {
    return getNode(key) == null;
  }

  @Override
  public V get(K key) {
    Node node = getNode(key);
    return null == node ? null : node.value;
  }

  @Override
  public void set(K key, V value) {
    Node node = getNode(key);
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

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    Node current = dummyHead.next;
    while (null != current) {
      builder.append(current.toString()).append(",");
      current = current.next;
    }
    return builder.toString();
  }

  private class Node {

    public K key;
    public V value;
    public Node next;

    public Node() {
      this(null, null, null);
    }

    public Node(K key) {
      this(key, null, null);
    }

    public Node(K key, V value) {
      this(key, value, null);
    }

    public Node(K key, V value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    @Override
    public String toString() {
      return key.toString() + " : " + value.toString();
    }
  }

  public static void main(String[] args) {

    LinkedListMap<String, Integer> map = new LinkedListMap<>();
    map.add("hello", 1);
    map.add("hello", 1);
    map.add("ap", 1);
    map.add("test", 1);
    map.add("world", 1);
    System.out.println(map);
    System.out.println(map.getSize());
    map.remove("test");
    System.out.println(map);
  }

}

