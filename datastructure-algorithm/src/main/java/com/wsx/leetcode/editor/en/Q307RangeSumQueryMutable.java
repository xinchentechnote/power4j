package com.wsx.leetcode.editor.en;

//Given an integer array nums, find the sum of the elements between indices i an
//d j (i ≤ j), inclusive. 
//
// The update(i, val) function modifies nums by updating the element at index i 
//to val. 
//
// Example: 
//
// 
//Given nums = [1, 3, 5]
//
//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
// 
//
// Note: 
//
// 
// The array is only modifiable by the update function. 
// You may assume the number of calls to update and sumRange function is distrib
//uted evenly. 
// 
// Related Topics Binary Indexed Tree Segment Tree 
// 👍 1281 👎 81


//Java：Range Sum Query - Mutable
public class Q307RangeSumQueryMutable {

  public static void main(String[] args) {
    int[] data = new int[]{1, 3, 5};
    NumArray solution = new NumArray(data);
    // TO TEST
    System.out.println(solution.sumRange(0, 2));
    solution.update(1, 2);
    System.out.println(solution.sumRange(0, 2));
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class NumArray {

    SegmentTree<Integer> tree;

    public NumArray(int[] nums) {
      Integer[] data = new Integer[nums.length];
      for (int i = 0; i < nums.length; i++) {
        data[i] = nums[i];
      }
      if (data.length > 0) {
        tree = new SegmentTree<>(data, (a, b) -> a + b);
      }
    }

    public void update(int i, int val) {
      if (null != tree) {
        tree.set(i, val);
      }
    }

    public int sumRange(int i, int j) {
      if (null != tree) {
        return tree.query(i, j);
      }
      return 0;
    }

    private interface Merger<E> {

      E merge(E a, E b);

    }

    private class SegmentTree<E> {

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

      public void set(int index, E e) {
        if (0 > index || index >= data.length) {
          throw new IllegalArgumentException("index is illegal.");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
      }

      private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
          tree[treeIndex] = e;
          return;
        }
        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChildIndex = rightChildIndex(treeIndex);
        if (index >= mid + 1) {
          set(rightChildIndex, mid + 1, r, index, e);
        } else {
          set(leftChildIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
      }

      public E query(int queryL, int queryR) {
        if (queryL > queryR || queryL < 0 || queryL >= data.length ||
            queryR < 0 || queryR >= data.length) {
          throw new IllegalArgumentException("index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
      }

      /**
       *@Description 在以treeIndex为根的线段树中[l...r]的范围里，搜索[queryL...queryR]的值.
       *@Author wusx
       *@Date 下午10:32 2020/7/10
       *@Modified
       */
      private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
          return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChildIndex = rightChildIndex(treeIndex);
        if (queryL >= mid + 1) {
          return query(rightChildIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
          return query(leftChildIndex, l, mid, queryL, queryR);
        } else {
          E left = query(leftChildIndex, l, mid, queryL, mid);
          E right = query(rightChildIndex, mid + 1, r, mid + 1, queryR);
          return merger.merge(left, right);
        }
      }

    }

  }

  /**
   * .
   * @Description 解法一，时间复杂度：O(n)
   * @Author:ShangxiuWu
   * @Date: 13:21 2020/7/11.
   * @Modified By:
   */
  class NumArray2 {

    int[] sums;
    int[] data;

    public NumArray2(int[] nums) {
      sums = new int[nums.length + 1];
      data = new int[nums.length];
      sums[0] = 0;
      for (int i = 0; i < nums.length; i++) {
        sums[i + 1] = nums[i] + sums[i];
        data[i] = nums[i];
      }
    }

    public void update(int i, int val) {
      data[i] = val;
      for (int j = i; j < data.length; j++) {
        sums[j + 1] = data[j] + sums[j];
      }
    }

    public int sumRange(int i, int j) {
      return sums[j + 1] - sums[i];
    }
  }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)

}