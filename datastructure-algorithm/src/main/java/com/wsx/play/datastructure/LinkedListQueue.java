package com.wsx.play.datastructure;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午11:55 2020/6/27.
 * @Modified By:
 */
public class LinkedListQueue<E> implements Queue<E> {


  private Node head;

  private Node tail;

  private int size;

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


  public LinkedListQueue() {

  }

  @Override
  public void enqueue(E e) {
    if (null == tail) {
      tail = new Node(e);
      head = tail;
    } else {
      tail.next = new Node(e);
      tail = tail.next;
    }
    size++;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException("cannot dequeue from an empty queue..");
    }
    Node result = head;
    head = head.next;
    size--;
    result.next = null;
    if (null == head) {
      tail = null;
    }
    return result.e;
  }

  @Override
  public E getFront() {
    if (isEmpty()) {
      throw new IllegalArgumentException("queue is empty.");
    }
    return head.e;
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

    builder.append("lindedList ");
    if (null != head) {
      Node cur = head;
      while (null != cur.next) {
        builder.append(cur.e);
        cur = cur.next;
        builder.append("->");
      }
    }
    builder.append("null");

    return builder.toString();
  }

  public static void main(String[] args) {
    LinkedListQueue<Integer> arrayQueue = new LinkedListQueue<>();
    for (int i = 0; i < 10; i++) {
      arrayQueue.enqueue(i);
    }
    System.out.println(arrayQueue.toString());
    System.out.println(arrayQueue.dequeue());
    System.out.println(arrayQueue.dequeue());
    System.out.println(arrayQueue.dequeue());
    System.out.println(arrayQueue.dequeue());
    System.out.println(arrayQueue.toString());

  }

}
