package com.wsx.play.datastructure;

import com.google.common.base.Stopwatch;
import lombok.ToString;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午12:27 2020/6/27.
 * @Modified By:
 */
public class LoopQueue<E> implements Queue<E> {

  private E[] data;

  private int tail;

  private int front;

  private int size;

  public LoopQueue() {
    this(16);
  }

  public LoopQueue(int capacity) {
    data = (E[]) new Object[capacity + 1];
    this.size = 0;
    this.front = 0;
    this.tail = 0;
  }

  @Override
  public void enqueue(E e) {
    //队列满
    if ((this.tail + 1) % data.length == this.front) {
      resize(getCapacity() * 2);
    }
    data[this.tail] = e;
    tail = (tail + 1) % data.length;
    size++;
  }

  private void resize(int newCapacity) {
    E[] newData = (E[]) new Object[newCapacity + 1];
    for (int i = 0; i < this.size; i++) {
      newData[i] = data[(i + this.front) % data.length];
    }
    this.data = newData;
    this.front = 0;
    this.tail = size;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new IllegalArgumentException("cannot dequeue from an empty queue.");
    }
    E result = data[front];
    data[front] = null;
    front = (front + 1) % data.length;
    size--;
    if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
      resize(getCapacity() / 2);
    }
    return result;
  }

  @Override
  public E getFront() {
    return data[front];
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.front == this.tail;
  }

  public int getCapacity() {
    return data.length - 1;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("LoopQueue ");
    builder.append("front [");
    for (int i = 0; i < size; i++) {
      builder.append(data[(i + front) % data.length]);
      if (i != size - 1) {
        builder.append(", ");
      }
    }
    builder.append("] tail");
    return builder.toString();
  }

  public static void main(String[] args) {

    LoopQueue<Integer> loopQueue = new LoopQueue<>();
    for (int i = 0; i < 100; i++) {
      loopQueue.enqueue(i);
    }
    System.out.println(loopQueue);
    System.out.println(loopQueue.dequeue());
    System.out.println(loopQueue.dequeue());
    System.out.println(loopQueue);

    int count = 10_000_000;

    //testQueue(new ArrayQueue<>(),count);
    testQueue(new LoopQueue<>(),count);
    testQueue(new LinkedListQueue<>(),count);

  }

  public static void testQueue(Queue<Integer> queue,int num){

    Stopwatch stopwatch = Stopwatch.createStarted();
    for (int i = 0; i < num; i++) {
      queue.enqueue(i);
    }
    for (int i = 0; i < num; i++) {
      queue.dequeue();
    }
    System.out.println(stopwatch.stop().toString());
  }
}
