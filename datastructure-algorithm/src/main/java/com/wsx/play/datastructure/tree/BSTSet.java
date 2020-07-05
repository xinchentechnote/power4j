package com.wsx.play.datastructure.tree;

import java.io.Serializable;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 15:10 2020/7/5.
 * @Modified By:
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

  public static void main(String[] args) {
    BSTSet<String> set = new BSTSet<>();
    set.add("hello");
    set.add("world");
    set.add("world");
    System.out.println(set.getSize());
    System.out.println(set.contains("hello"));
    System.out.println(set.contains("hw"));
  }

  private BSTree<E> bst;

  public BSTSet() {
    this.bst = new BSTree<>();
  }

  @Override
  public void add(E e) {
    bst.add(e);
  }

  @Override
  public void remove(E e) {
    bst.remove(e);
  }

  @Override
  public boolean contains(E e) {
    return bst.contains(e);
  }

  @Override
  public int getSize() {
    return bst.getSize();
  }

  @Override
  public boolean isEmpty() {
    return bst.isEmpty();
  }
}
