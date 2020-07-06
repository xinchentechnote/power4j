package com.wsx.play.datastructure;

import com.wsx.play.datastructure.tree.MaxHeap;

/**
 * .
 * @Description
 * @Author:ShangxiuWu
 * @Date: 下午8:46 2020/6/26.
 * @Modified By:
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

  private MaxHeap<E> maxHeap;

  public PriorityQueue() {
    this.maxHeap = new MaxHeap<>();
  }

  @Override
  public void enqueue(E e) {
    this.maxHeap.add(e);
  }

  @Override
  public E dequeue() {
    return this.maxHeap.extractMax();
  }

  @Override
  public E getFront() {
    return this.maxHeap.findMax();
  }

  @Override
  public int getSize() {
    return this.maxHeap.size();
  }

  @Override
  public boolean isEmpty() {
    return this.maxHeap.isEmpty();
  }
}
