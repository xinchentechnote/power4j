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

  public MaxHeap(E[] data) {
    this.data = new Array<>(data);
    //heapify数组堆化
    for (int i = parentIndex(data.length - 1); i >= 0; i--) {
      siftDown(i);
    }
  }

  /**
   *@Description 向堆中添加元素.
   *@Author wusx
   *@Date 21:15 2020/7/6
   *@Modified
   */
  public void add(E e) {
    data.addLast(e);
    siftUp(data.size() - 1);
  }

  private void siftUp(int index) {
    while (index > 0 && data.get(parentIndex(index)).compareTo(data.get(index)) < 0) {
      data.swap(parentIndex(index), index);
      index = parentIndex(index);
    }
  }

  public E extractMax() {
    E max = findMax();
    data.swap(0, data.size() - 1);
    data.removeLast();
    siftDown(0);
    return max;
  }

  private void siftDown(int index) {
    while (leftChildIndex(index) < data.size()) {
      int maxChildIndex = leftChildIndex(index);
      if (maxChildIndex + 1 < data.size()
          && data.get(maxChildIndex + 1).compareTo(data.get(maxChildIndex)) > 0) {
        maxChildIndex++;
      }
      if (data.get(maxChildIndex).compareTo(data.get(index)) > 0) {
        data.swap(maxChildIndex, index);
        index = maxChildIndex;
      } else {
        break;
      }

    }
  }

  public E findMax() {
    if (data.isEmpty()) {
      throw new IllegalArgumentException("heap is empty.");
    }
    return data.get(0);
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

  public E replace(E e) {
    E ret = findMax();
    data.set(0, e);
    siftDown(0);
    return ret;
  }

  public static void main(String[] args) {
    MaxHeap<Integer> heap = new MaxHeap<>();
    heap.add(1);
    heap.add(4);
    heap.add(9);
    heap.add(8);
    heap.add(5);
    while (!heap.isEmpty()) {
      System.out.print(heap.extractMax() + " ");
    }
    System.out.println();

    Integer[] data = new Integer[]{4,5,3,67,2,89,6};
    MaxHeap<Integer> maxHeap = new MaxHeap<>(data);
    while (!maxHeap.isEmpty()) {
      System.out.print(maxHeap.extractMax() + " ");
    }
    System.out.println();
  }

}
