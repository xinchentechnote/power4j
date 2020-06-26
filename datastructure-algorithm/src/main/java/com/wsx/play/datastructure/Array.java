package com.wsx.play.datastructure;

/**.
 * @Author:wusx
 * @Date: Created in 19:18 2020/4/7 0007.
 * @Description 玩转数据结构，数组.
 * @Modified By:
 * 复杂度分析：
 *
 */
public class Array<E> {

  private static int defaultSize = 16;

  private E[] data;

  private int size;

  public Array() {
    this(defaultSize);
  }

  public Array(int capacity) {
    this.data = (E[]) new Object[capacity];
    this.size = 0;
  }

  //增删改查
  public void addFirst(E e) {
    add(0, e);
  }

  public void addLast(E e) {
    add(size, e);
  }

  //添加元素
  public void add(int index, E e) {

    if (index < 0 || index > size) {
      throw new IllegalArgumentException("addLast failed. Require 0<=index<=size");
    }

    if (this.size == data.length) {
      resize(2 * data.length);
    }

    for (int i = this.size; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = e;
    size++;
  }

  //获取
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed. Index is illegal...");
    }
    return data[index];
  }

  //修改
  public void set(int index, E e) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed. Index is illegal...");
    }
    data[index] = e;
  }

  public boolean contains(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i] == e) {
        return true;
      }
    }
    return false;
  }

  public int find(E e) {
    for (int i = 0; i < size; i++) {
      if (e.equals(data[i])) {
        return i;
      }
    }
    return -1;
  }

  public E remove(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("remove failed. Require 0<=index<=size");
    }
    E result = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    data[size - 1] = null;
    size--;
    if (size == data.length / 2) {
      resize(data.length * 3 / 4);
    }
    return result;
  }

  public E removeFirst() {
    return remove(0);
  }

  public E removeLast() {
    return remove(size - 1);
  }

  public void removeElement(E e) {
    int index = find(e);
    if (index != -1) {
      remove(index);
    }
  }

  public int size() {
    return this.size;
  }

  public int getCapacity() {
    return data.length;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private void resize(int capacity) {
    E[] newData = (E[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Array size = " + size + ",capacity = " + data.length);
    builder.append("\n");
    builder.append("[");
    for (int i = 0; i < size; i++) {
      builder.append(data[i]);
      if (i != size - 1) {
        builder.append(", ");
      }
    }
    builder.append("]");
    return builder.toString();
  }

  public static void main(String[] args) {
    Array<Integer> array = new Array<>(5);
    System.out.println(array.toString());
    for (int i = 0; i < 10; i++) {
      array.addLast(i);
    }
    array.addFirst(10);
    array.add(3, 9);
    System.out.println(array.toString());
    System.out.println(array.find(3));
    System.out.println(array.toString());
    System.out.println(array.remove(7));
    System.out.println(array.toString());
    array.removeElement(7);
    System.out.println(array.toString());
  }

}
