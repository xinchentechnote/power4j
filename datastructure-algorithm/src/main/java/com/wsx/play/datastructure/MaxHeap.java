package com.wsx.play.datastructure;

/**
 * @Description 最小堆，最大堆，求top k问题
 *              结合最大堆和最小堆，求中位数.
 * @Author:ShangxiuWu
 * @Date: 9:23 2020/6/19.
 * @Modified By:
 */
public class MaxHeap<E extends Comparable<E>> {

  private Array<E> data;

  public MaxHeap() {
    this.data = new Array<>();
  }

  public MaxHeap(int capacity) {
    this.data = new Array<>(capacity);
  }

  private int parentIndex(int index) {
    if (index == 0) {
      throw new IllegalArgumentException("index 0 doesn't have parent.");
    }
    return (index - 1) / 2;
  }

  private int leftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int rightChildIndex(int index) {
    return index * 2 + 2;
  }


  public int size() {
    return data.size();
  }

  public boolean isEmpty() {
    return data.isEmpty();
  }

}
