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
public class BSTree<K extends Comparable<K>, V> {


  public static void main(String[] args) {

    BSTree<Integer, Integer> bst = new BSTree<>();
    int[] data = new int[]{5, 3, 6, 8, 4, 2};
    for (int i = 0; i < data.length; i++) {
      bst.add(data[i], data[i]);
    }
    //排序
    bst.remove(2);
    bst.inOrder();
    while (!bst.isEmpty()) {
      System.out.print(bst.removeMax() + " ");
    }
    System.out.println();

  }

  private BSTNode<K, V> rootNode;

  private int size;

  public BSTree() {
    this.rootNode = null;
    this.size = 0;
  }

  public BSTree(BSTNode<K, V> rootNode) {
    this.rootNode = rootNode;
    this.size++;
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }


  public void add(K key, V value) {
    this.rootNode = add(rootNode, key, value);
  }

  //将元素插入指定节点中
  private BSTNode<K, V> add(BSTNode<K, V> node, K key, V value) {
    if (null == node) {
      size++;
      return new BSTNode<>(key, value);
    }
    if (key.compareTo(node.key) < 0) {
      node.left = add(node.left, key, value);
    } else if (key.compareTo(node.key) > 0) {
      node.right = add(node.right, key, value);
    }
    return node;
  }

  //查询
  public boolean contains(K key) {
    return contains(this.rootNode, key);
  }

  private boolean contains(BSTNode<K, V> node, K key) {
    //终止条件
    if (null == node) {
      return false;
    }
    if (key.equals(node.key)) {
      return true;
    }
    //递归调用
    if (key.compareTo(node.key) < 0) {
      return contains(node.left, key);
    } else {
      return contains(node.right, key);
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
      System.out.print(pop.key + " ");
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
  private void preOrder(BSTNode<K, V> node) {
    if (null == node) {
      return;
    }
    System.out.print(node.key + " ");
    preOrder(node.left);
    preOrder(node.right);
  }


  //中序遍历：排序
  public void inOrder() {
    inOrder(this.rootNode);
    System.out.println();
  }

  private void inOrder(BSTNode<K, V> node) {
    if (null == node) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.key + " ");
    inOrder(node.right);
  }

  //后序遍历：释放内存
  public void postOrder() {
    postOrder(this.rootNode);
    System.out.println();
  }

  private void postOrder(BSTNode<K, V> node) {
    if (null == node) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.key + " ");
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
      System.out.print(remove.key + " ");
    }
    System.out.println();
  }

  /**
   *@Description 二分搜索树的最小值.
   *@Author wusx
   *@Date 14:25 2020/7/5
   *@Modified
   */
  public K minimum() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("BST is empty");
    }
    return minimum(rootNode).key;
  }

  private BSTNode<K, V> minimum(BSTNode<K, V> node) {
    if (null == node.left) {
      return node;
    }
    return minimum(node.left);
  }

  public K removeMin() {
    K k = minimum();
    rootNode = removeMin(rootNode);
    return k;
  }

  private BSTNode<K, V> removeMin(BSTNode<K, V> node) {
    if (null == node.left) {
      BSTNode<K, V> right = node.right;
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
  public K maximum() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("BST is empty");
    }
    return maximum(rootNode).key;
  }

  private BSTNode<K, V> maximum(BSTNode<K, V> node) {
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
  public K removeMax() {
    K k = maximum();
    rootNode = removeMax(rootNode);
    return k;
  }

  private BSTNode<K, V> removeMax(BSTNode<K, V> node) {
    if (null == node.right) {
      BSTNode<K, V> left = node.left;
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
  public void remove(K key) {
    rootNode = remove(rootNode, key);
  }

  private BSTNode<K, V> remove(BSTNode<K, V> node, K key) {
    if (null == node) {
      return null;
    }
    if (key.compareTo(node.key) > 0) {
      node.right = remove(node.right, key);
      return node;
    } else if (key.compareTo(node.key) < 0) {

      node.left = remove(node.left, key);
      return node;
    } else {

      if (null == node.left) {
        BSTNode<K, V> right = node.right;
        node.right = null;
        size--;
        return right;
      }

      if (null == node.right) {
        BSTNode<K, V> left = node.left;
        node.left = null;
        size--;
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

  private void generateBSTString(BSTNode<K, V> node, int depth, StringBuilder builder) {
    if (null == node) {
      builder.append(generateDepthString(depth) + "null\n");
      return;
    }
    builder.append(generateDepthString(depth) + node.key + "\n");
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


  public class BSTNode<K extends Comparable<K>, V> {

    private K key;
    private V value;
    private BSTNode<K, V> left;
    private BSTNode<K, V> right;

    public BSTNode(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
    }

    public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

}
