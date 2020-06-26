package com.wsx.play.datastructure;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午11:52 2020/6/26.
 * @Modified By:
 */
public class ArrayStack<E> implements Stack<E> {

  private Array<E> data;

  public ArrayStack() {
    this(16);
  }

  public ArrayStack(int capacity) {
    this.data = new Array<>(capacity);
  }

  @Override
  public void push(E e) {
    data.addLast(e);
  }

  @Override
  public E pop() {
    return data.removeLast();
  }

  @Override
  public E peek() {
    return data.getLast();
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
    builder.append("stack : ")
        .append("[");
    for (int i = 0; i < data.size(); i++) {
      builder.append(data.get(i));
      if (i != data.size() - 1) {
        builder.append(", ");
      }
    }
    builder.append("] top");
    return builder.toString();
  }

  public static void main(String[] args) {
    ArrayStack<Integer> stack = new ArrayStack<>();
    for (int i = 0; i < 10; i++) {
      stack.push(i);
    }
    System.out.println(stack);
  }
}
