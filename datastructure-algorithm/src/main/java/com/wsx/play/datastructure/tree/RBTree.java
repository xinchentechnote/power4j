package com.wsx.play.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 红黑树.
 * @Description
 * @Author:ShangxiuWu
 * @Date: 19:25 2020/7/12.
 * @Modified By:
 */
public class RBTree<K extends Comparable<K>, V> {


  public static void main(String[] args) {

    RBTree<Integer, Integer> bst = new RBTree<>();
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

  private Node<K, V> root;

  private int size;

  public RBTree() {
    this.root = null;
    this.size = 0;
  }

  public RBTree(Node<K, V> root) {
    this.root = root;
    this.size++;
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }


  public void add(K key, V value) {
    this.root = add(root, key, value);
    this.root.color = Node.RED;
  }

  //将元素插入指定节点中
  private Node<K, V> add(Node<K, V> node, K key, V value) {
    if (null == node) {
      size++;
      return new Node<>(key, value);
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
    return contains(this.root, key);
  }

  private boolean contains(Node<K, V> node, K key) {
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
    preOrder(this.root);
    System.out.println();
  }

  //非递归前序遍历
  public void preOrderNR() {
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      Node pop = stack.pop();
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
  private void preOrder(Node<K, V> node) {
    if (null == node) {
      return;
    }
    System.out.print(node.key + " ");
    preOrder(node.left);
    preOrder(node.right);
  }


  //中序遍历：排序
  public void inOrder() {
    inOrder(this.root);
    System.out.println();
  }

  private void inOrder(Node<K, V> node) {
    if (null == node) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.key + " ");
    inOrder(node.right);
  }

  //后序遍历：释放内存
  public void postOrder() {
    postOrder(this.root);
    System.out.println();
  }

  private void postOrder(Node<K, V> node) {
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
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node remove = queue.remove();
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
    return minimum(root).key;
  }

  private Node<K, V> minimum(Node<K, V> node) {
    if (null == node.left) {
      return node;
    }
    return minimum(node.left);
  }

  public K removeMin() {
    K k = minimum();
    root = removeMin(root);
    return k;
  }

  private Node<K, V> removeMin(Node<K, V> node) {
    if (null == node.left) {
      Node<K, V> right = node.right;
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
    return maximum(root).key;
  }

  private Node<K, V> maximum(Node<K, V> node) {
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
    root = removeMax(root);
    return k;
  }

  private Node<K, V> removeMax(Node<K, V> node) {
    if (null == node.right) {
      Node<K, V> left = node.left;
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
    root = remove(root, key);
  }

  private Node<K, V> remove(Node<K, V> node, K key) {
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
        Node<K, V> right = node.right;
        node.right = null;
        size--;
        return right;
      }

      if (null == node.right) {
        Node<K, V> left = node.left;
        node.left = null;
        size--;
        return left;
      }

      Node newNode = minimum(node.right);
      newNode.right = removeMin(node.right);
      newNode.left = node.left;

      node.left = node.right = null;
      return newNode;
    }
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    generateBSTString(this.root, 0, builder);
    return builder.toString();
  }

  private void generateBSTString(Node<K, V> node, int depth, StringBuilder builder) {
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


  private class Node<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private K key;
    private V value;
    private boolean color;
    private Node<K, V> left;
    private Node<K, V> right;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
      this.color = RED;
    }

    public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
      this.color = RED;
    }

    public boolean isRed() {
      return this.color;
    }
  }

}
