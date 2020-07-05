package com.wsx.play.datastructure.tree;

import com.wsx.play.datastructure.LinkedList;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 18:14 2020/7/5.
 * @Modified By:
 */
public class LinkedListSet<E> implements Set<E> {

  private LinkedList<E> linkedList;

  public LinkedListSet() {
    this.linkedList = new LinkedList<>();
  }

  @Override
  public void add(E e) {
    if (!linkedList.contains(e)) {
      linkedList.addFirst(e);
    }
  }

  @Override
  public void remove(E e) {
    linkedList.removeElement(e);
  }

  @Override
  public boolean contains(E e) {
    return linkedList.contains(e);
  }

  @Override
  public int getSize() {
    return linkedList.getSize();
  }

  @Override
  public boolean isEmpty() {
    return linkedList.isEmpty();
  }

  @Override
  public String toString() {
    return linkedList.toString();
  }

  public static void main(String[] args) {
    LinkedListSet<Integer> set = new LinkedListSet<>();
    set.add(7);
    set.add(1);
    set.add(6);
    set.add(1);
    set.add(5);
    System.out.println(set);
  }
}
