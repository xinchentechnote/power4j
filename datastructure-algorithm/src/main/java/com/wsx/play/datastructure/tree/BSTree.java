package com.wsx.play.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description 二分搜索树.
 * @Author:ShangxiuWu
 * @Date: 22:51 2020/6/21.
 * @Modified By:
 */
public class BSTree<T extends Comparable<T>> {


  public static void main(String[] args) {

    BSTree<Integer> bst = new BSTree<>();
    int[] data = new int[]{5, 3, 6, 8, 4, 2};
    for (int i = 0; i < data.length; i++) {
      bst.add(data[i]);
    }
    //排序
    bst.remove(2);
    bst.inOrder();
    while (!bst.isEmpty()) {
      System.out.print(bst.removeMax() + " ");
    }
    System.out.println();

  }

  private BSTNode<T> rootNode;

  private int size;

  public BSTree() {
    this.rootNode = null;
    this.size = 0;
  }

  public BSTree(BSTNode<T> rootNode) {
    this.rootNode = rootNode;
    this.size++;
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }


  public void add(T value) {
    this.rootNode = add(rootNode, value);
  }

  //将元素插入指定节点中
  private BSTNode<T> add(BSTNode<T> node, T value) {
    if (null == node) {
      size++;
      return new BSTNode<>(value);
    }
    if (value.compareTo(node.value) < 0) {
      node.left = add(node.left, value);
    } else if (value.compareTo(node.value) > 0) {
      node.right = add(node.right, value);
    }
    return node;
  }

  //查询
  public boolean contains(T value) {
    return contains(this.rootNode, value);
  }

  private boolean contains(BSTNode<T> node, T value) {
    //终止条件
    if (null == node) {
      return false;
    }
    if (value.equals(node.value)) {
      return true;
    }
    //递归调用
    if (value.compareTo(node.value) < 0) {
      return contains(node.left, value);
    } else {
      return contains(node.right, value);
    }
  }

  //递归前序遍历
  public void preOrder() {
    preOrder(this.rootNode);
    System.out.println();
  }

  //非递归前序遍历
  public void preOrderNR() {
    Stack<BSTNode> stack = new Stack<>();
    stack.push(rootNode);
    while (!stack.empty()) {
      BSTNode pop = stack.pop();
      System.out.print(pop.value + " ");
      if (null != pop.right) {
        stack.push(pop.right);
      }
      if (null != pop.left) {
        stack.push(pop.left);
      }
    }
    System.out.println();
  }

  //前序遍历：打印
  private void preOrder(BSTNode<T> node) {
    if (null == node) {
      return;
    }
    System.out.print(node.value + " ");
    preOrder(node.left);
    preOrder(node.right);
  }


  //中序遍历：排序
  public void inOrder() {
    inOrder(this.rootNode);
    System.out.println();
  }

  private void inOrder(BSTNode<T> node) {
    if (null == node) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.value + " ");
    inOrder(node.right);
  }

  //后序遍历：释放内存
  public void postOrder() {
    postOrder(this.rootNode);
    System.out.println();
  }

  private void postOrder(BSTNode<T> node) {
    if (null == node) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value + " ");
  }

  /**
   *@Description 层序遍历（广度优先遍历）.
   *@Author wusx
   *@Date 14:16 2020/7/5
   *@Modified
   */
  public void levelOrder() {
    Queue<BSTNode> queue = new LinkedList<>();
    queue.add(rootNode);
    while (!queue.isEmpty()) {
      BSTNode remove = queue.remove();
      if (null != remove.left) {
        queue.add(remove.left);
      }
      if (null != remove.right) {
        queue.add(remove.right);
      }
      System.out.print(remove.value + " ");
    }
    System.out.println();
  }

  /**
   *@Description 二分搜索树的最小值.
   *@Author wusx
   *@Date 14:25 2020/7/5
   *@Modified
   */
  public T minimum() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("BST is empty");
    }
    return minimum(rootNode).value;
  }

  private BSTNode<T> minimum(BSTNode<T> node) {
    if (null == node.left) {
      return node;
    }
    return minimum(node.left);
  }

  public T removeMin() {
    T t = minimum();
    rootNode = removeMin(rootNode);
    return t;
  }

  private BSTNode<T> removeMin(BSTNode<T> node) {
    if (null == node.left) {
      BSTNode<T> right = node.right;
      node.right = null;
      size--;
      return right;
    }
    node.left = removeMin(node.left);
    return node;
  }

  /**
   *@Description 二分搜索树的最大值.
   *@Author wusx
   *@Date 14:24 2020/7/5
   *@Modified
   */
  public T maximum() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("BST is empty");
    }
    return maximum(rootNode).value;
  }

  private BSTNode<T> maximum(BSTNode<T> node) {
    if (null == node.right) {
      return node;
    }
    return maximum(node.right);
  }

  /**
   *@Description 删除最大值.
   *@Author wusx
   *@Date 14:48 2020/7/5
   *@Modified
   */
  public T removeMax() {
    T t = maximum();
    rootNode = removeMax(rootNode);
    return t;
  }

  private BSTNode<T> removeMax(BSTNode<T> node) {
    if (null == node.right) {
      BSTNode<T> left = node.left;
      node.left = null;
      size--;
      return left;
    }
    node.right = removeMax(node.right);
    return node;
  }

  /**
   *@Description 删除任意元素.
   *@Author wusx
   *@Date 14:49 2020/7/5
   *@Modified
   */
  public void remove(T value) {
    rootNode = remove(rootNode, value);
  }

  private BSTNode<T> remove(BSTNode<T> node, T value) {
    if (null == node) {
      return null;
    }
    if (value.compareTo(node.value) > 0) {
      node.right = remove(node.right, value);
      return node;
    } else if (value.compareTo(node.value) < 0) {

      node.left = remove(node.left, value);
      return node;
    } else {

      if (null==node.left){
        BSTNode<T> right = node.right;
        node.right = null;
        size--;
        return right;
      }

      if (null==node.right){
        BSTNode<T> left = node.left;
        node.left = null;
        size --;
        return left;
      }

      BSTNode newNode = minimum(node.right);
      newNode.right = removeMin(node.right);
      newNode.left = node.left;

      node.left = node.right = null;
      return newNode;
    }
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    generateBSTString(this.rootNode, 0, builder);
    return builder.toString();
  }

  private void generateBSTString(BSTNode<T> node, int depth, StringBuilder builder) {
    if (null == node) {
      builder.append(generateDepthString(depth) + "null\n");
      return;
    }
    builder.append(generateDepthString(depth) + node.value + "\n");
    generateBSTString(node.left, depth + 1, builder);
    generateBSTString(node.right, depth + 1, builder);
  }

  private String generateDepthString(int depth) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      builder.append("--");
    }
    return builder.toString();
  }


  public class BSTNode<T extends Comparable<T>> {

    private T value;
    private BSTNode<T> left;
    private BSTNode<T> right;
    private BSTNode<T> parent;

    public BSTNode(T value) {
      this.value = value;
      this.left = null;
      this.right = null;
      this.parent = null;
    }

    public BSTNode(T value, BSTNode<T> left, BSTNode<T> right,
        BSTNode<T> parent) {
      this.value = value;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }
  }

}
