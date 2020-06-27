package com.wsx.play.datastructure;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午2:18 2020/6/27.
 * @Modified By:
 */
public class LinkedList<E> {

  private class Node {

    public E e;

    public Node next;

    public Node() {
    }

    public Node(E e) {
      this(e, null);
    }

    public Node(E e, Node next) {
      this.e = e;
      this.next = next;
    }

    @Override
    public String toString() {
      return e.toString();
    }
  }

}
