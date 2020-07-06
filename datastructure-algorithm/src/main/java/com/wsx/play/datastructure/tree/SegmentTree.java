package com.wsx.play.datastructure.tree;

import java.util.Arrays;

/**
 * @Description 线段树（区间树）.
 * 平衡二叉树，叶子节点深度差不超过1
 * 求和线段树
 * @Author:ShangxiuWu
 * @Date: 23:29 2020/7/6.
 * @Modified By:
 */
public class SegmentTree<E> {

  private E[] tree;
  private E[] data;
  private Merger<E> merger;

  public SegmentTree(E[] arr, Merger<E> merger) {
    this.merger = merger;
    this.data = (E[]) new Object[arr.length];
    for (int i = 0; i < data.length; i++) {
      this.data[i] = arr[i];
    }
    this.tree = (E[]) new Object[data.length * 4];
    buildSegmentTree(0, 0, data.length - 1);
  }

  private void buildSegmentTree(int treeIndex, int left, int right) {

    if (left == right) {
      tree[treeIndex] = data[left];
      return;
    }
    int leftChildIndex = leftChildIndex(treeIndex);
    int rightChildIndex = rightChildIndex(treeIndex);
    int mid = left + (right - left) / 2;
    buildSegmentTree(leftChildIndex, left, mid);
    buildSegmentTree(rightChildIndex, mid + 1, right);
    tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
  }


  private int leftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int rightChildIndex(int index) {
    return index * 2 + 2;
  }

  public int getSize() {
    return data.length;
  }

  public E get(int index) {
    if (index < 0 || index >= data.length) {
      throw new IllegalArgumentException("illegal index.");
    }
    return data[index];
  }

  @Override
  public String toString() {
    return Arrays.toString(tree);
  }

  public static void main(String[] args) {
    Integer[] nums = new Integer[]{-2, 0, 3, -5, 2, -1};
    SegmentTree<Integer> tree = new SegmentTree<>(nums, (a, b) -> a + b);
    System.out.println(tree);
  }

}
