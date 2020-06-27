package com.wsx.play.datastructure;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午11:55 2020/6/27.
 * @Modified By:
 */
public class LinkedListQueue<E> implements Queue<E> {

  private LinkedList<E> data;

  public LinkedListQueue() {
    data = new LinkedList<>();
  }

  @Override
  public void enqueue(E e) {
    data.addFirst(e);
  }

  @Override
  public E dequeue() {
    return data.removeLast();
  }

  @Override
  public E getFront() {
    return data.getLast();
  }

  @Override
  public int getSize() {
    return data.getSize();
  }

  @Override
  public boolean isEmpty() {
    return data.isEmpty();
  }
}
