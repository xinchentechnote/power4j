package com.wsx.play.datastructure.tree;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 15:00 2020/7/12.
 * @Modified By:
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

  private AVLTree<E, Object> tree;

  public AVLSet() {
    this.tree = new AVLTree<>();
  }

  @Override
  public void add(E e) {
    tree.add(e, null);
  }

  @Override
  public void remove(E e) {
    tree.remove(e);
  }

  @Override
  public boolean contains(E e) {
    return tree.contains(e);
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
    Set<Integer> set = new AVLSet<>();
    set.add(7);
    set.add(1);
    set.add(6);
    System.out.println(set.getSize());
    set.add(1);
    set.add(1);
    set.add(5);
    System.out.println(set.getSize());
  }
}
