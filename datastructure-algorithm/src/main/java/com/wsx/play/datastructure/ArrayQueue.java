package com.wsx.play.datastructure;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午12:09 2020/6/27.
 * @Modified By:
 */
public class ArrayQueue<E> implements Queue<E> {

  private Array<E> data;

  public ArrayQueue() {
    this(16);
  }

  public ArrayQueue(int capacity) {
    data = new Array<>(capacity);
  }

  @Override
  public void enqueue(E e) {
    data.addLast(e);
  }

  @Override
  public E dequeue() {
    return data.removeFirst();
  }

  @Override
  public E getFront() {
    return data.getFirst();
  }

  @Override
  public int getSize() {
    return data.size();
  }

  @Override
  public boolean isEmpty() {
    return data.isEmpty();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("queue : ")
        .append("front [");
    for (int i = 0; i < data.size(); i++) {
      builder.append(data.get(i));
      if (i != data.size() - 1) {
        builder.append(", ");
      }
    }
    builder.append("] tail");
    return builder.toString();
  }

  public static void main(String[] args) {
    ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
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
