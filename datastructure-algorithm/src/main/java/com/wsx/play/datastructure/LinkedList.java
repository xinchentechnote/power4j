package com.wsx.play.datastructure;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午2:18 2020/6/27.
 * @Modified By:
 */
public class LinkedList<E> {

  //private Node Head;
  //使用虚拟头结点
  private Node dummyHead;
  private int size;

  public LinkedList() {
    dummyHead = new Node(null, null);
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void addFirst(E e) {
    //Node node = new Node(e);
    //node.next = head.next;
    //head.next = node;
    //head = new Node(e, head);
    add(0, e);
    //size++;
  }

  public void addLast(E e) {
    add(size, e);
  }

  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Add failed. Illegal index.");
    }
    //if (index == 0) {
    //  addFirst(e);
    //} else {
    //  Node pre = head;
    Node pre = dummyHead;
    for (int i = 0; i < index - 1; i++) {
      pre = pre.next;
    }
    //Node node = new Node(e);
    //node.next = pre.next;
    //pre.next = node;
    pre.next = new Node(e, pre.next);
    size++;
    //}
  }

  public E getFirst() {
    return get(0);
  }


  public E getLast() {
    return get(size - 1);
  }


  public E get(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Get failed. Illegal index.");
    }
    Node cur = dummyHead.next;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    return cur.e;
  }

  public void set(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Set failed. Illegal index.");
    }
    Node cur = dummyHead.next;
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    cur.e = e;
  }

  public boolean contains(E e) {
    Node cur = dummyHead.next;
    while (cur.next != null) {
      if (cur.e.equals(e)) {
        return true;
      }
    }
    return false;
  }

  public E remove(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Remove failed. Illegal index.");
    }
    Node pre = dummyHead;
    for (int i = 0; i < index; i++) {
      pre = pre.next;
    }
    Node target = pre.next;
    pre.next = pre.next.next;
    target.next = null;
    size--;
    return target.e;
  }

  public E removeFirst() {
    return remove(0);
  }

  public E removeLast() {
    return remove(size - 1);
  }


  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();

    Node cur = dummyHead.next;
    builder.append("lindedList [");
    while (null != cur.next) {
      builder.append(cur.e);
      cur = cur.next;
      builder.append("->");
    }
    builder.append("null");

    return builder.toString();
  }

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

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      linkedList.addFirst(i);
    }
    System.out.println(linkedList);
    linkedList.addLast(10);
    System.out.println(linkedList);
    linkedList.set(2, 8);
    System.out.println(linkedList);
    linkedList.removeFirst();
    System.out.println(linkedList);
    linkedList.removeLast();
    System.out.println(linkedList);
  }

}
