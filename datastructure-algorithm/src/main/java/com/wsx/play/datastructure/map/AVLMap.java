package com.wsx.play.datastructure.map;

import com.wsx.play.datastructure.tree.AVLTree;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 14:26 2020/7/12.
 * @Modified By:
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

  private AVLTree<K, V> tree;

  public AVLMap() {
    this.tree = new AVLTree<>();
  }

  @Override
  public void add(K key, V value) {
    tree.add(key, value);
  }

  @Override
  public V remove(K key) {
    return tree.remove(key);
  }

  @Override
  public boolean contains(K key) {
    return tree.contains(key);
  }

  @Override
  public V get(K key) {
    return tree.get(key);
  }

  @Override
  public void set(K key, V value) {
    tree.set(key, value);
  }

  @Override
  public int getSize() {
    return tree.getSize();
  }

  @Override
  public boolean isEmpty() {
    return tree.isEmpty();
  }

  public static void main(String[] args) {

    Map<String, Integer> map = new AVLMap<>();
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
