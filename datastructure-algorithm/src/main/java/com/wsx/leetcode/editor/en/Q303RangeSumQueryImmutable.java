package com.wsx.leetcode.editor.en;

//Given an integer array nums, find the sum of the elements between indices i an
//d j (i ≤ j), inclusive. 
//
// Example: 
// 
//Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
// 
// 
//
// Note: 
// 
// You may assume that the array does not change. 
// There are many calls to sumRange function. 
// 
// Related Topics Dynamic Programming 
// 👍 867 👎 1068


//Java：Range Sum Query - Immutable
public class Q303RangeSumQueryImmutable {

  public static void main(String[] args) {
    int[] data = new int[]{-2, 0, 3, -5, 2, -1};
    NumArray solution = new NumArray(data);
    // TO TEST
    System.out.println(solution.sumRange(3, 5));
  }

//    class NumArray {
//
//        private int[] sums;
//
//        public NumArray(int[] nums) {
//            sums = new int[nums.length + 1];
//            sums[0] = 0;
//            for (int i = 1; i <= nums.length; i++) {
//                sums[i] = nums[i - 1] + sums[i - 1];
//            }
//        }
//
//        public int sumRange(int i, int j) {
//            return sums[j + 1] - sums[i];
//        }
//    }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class NumArray {

    private SegmentTree<Integer> tree;

    public NumArray(int[] nums) {
      Integer[] data = new Integer[nums.length];
      for (int i = 0; i < nums.length; i++) {
        data[i] = nums[i];
      }
      if (data.length > 0) {
        tree = new SegmentTree<>(data, (a, b) -> a + b);
      }
    }

    public int sumRange(int i, int j) {
      if (null == tree) {
        return 0;
      }
      return tree.query(i, j);
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
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)


}