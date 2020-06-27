package com.wsx.play.datastructure;

import com.google.common.base.Stopwatch;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午11:46 2020/6/27.
 * @Modified By:
 */
public class LinkedListStack<E> implements Stack<E> {

  private LinkedList<E> data;

  public LinkedListStack() {
    data = new LinkedList<>();
  }

  @Override
  public void push(E e) {
    data.addFirst(e);
  }

  @Override
  public E pop() {
    return data.removeFirst();
  }

  @Override
  public E peek() {
    return data.getFirst();
  }

  @Override
  public int getSize() {
    return data.getSize();
  }

  @Override
  public boolean isEmpty() {
    return data.isEmpty();
  }


  public static void main(String[] args) {
    testStack(new LinkedListStack<>(), 10_0000);
    testStack(new ArrayStack<>(), 10_0000);
  }

  public static void testStack(Stack<Integer> stack, int num) {

    Stopwatch stopwatch = Stopwatch.createStarted();
    for (int i = 0; i < num; i++) {
      stack.push(i);
    }
    for (int i = 0; i < num; i++) {
      stack.pop();
    }
    System.out.println(stopwatch.stop().toString());
  }

}
