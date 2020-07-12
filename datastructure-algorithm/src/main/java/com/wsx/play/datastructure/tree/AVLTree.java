package com.wsx.play.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description 二分搜索树.
 * @Author:ShangxiuWu
 * @Date: 22:51 2020/6/21.
 * @Modified By:
 */
public class AVLTree<T extends Comparable<T>> {


  public static void main(String[] args) {

    AVLTree<Integer> bst = new AVLTree<>();
    int[] data = new int[]{1, 2, 3, 4, 5, 6, 10, 9, 8, 7};
    for (int i = 0; i < data.length; i++) {
      bst.add(data[i]);
      //System.out.println(bst.isBalanced());
    }
    bst.remove(5);
    bst.inOrder();
    System.out.println("---------层序遍历--------");
    bst.levelOrder();
    while (!bst.isEmpty()) {
      System.out.print(bst.removeMax() + " ");
    }
    System.out.println();

  }

  private Node<T> rootNode;

  private int size;

  public AVLTree() {
    this.rootNode = null;
    this.size = 0;
  }

  public AVLTree(Node<T> rootNode) {
    this.rootNode = rootNode;
    this.size++;
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   *@Description 获取节点的高度.
   *@Author wusx
   *@Date 10:32 2020/7/12
   *@Modified
   */
  private int getHeight(Node<T> node) {
    if (null == node) {
      return 0;
    }
    return node.height;
  }

  /**
   *@Description 计算节点的平衡因子.
   *@Author wusx
   *@Date 10:34 2020/7/12
   *@Modified
   */
  private int getBalanceFactor(Node<T> node) {
    return getHeight(node.left) - getHeight(node.right);
  }

  public void add(T value) {
    this.rootNode = add(rootNode, value);
  }

  //将元素插入指定节点中
  private Node<T> add(Node<T> node, T value) {
    if (null == node) {
      size++;
      return new Node<>(value);
    }
    if (value.compareTo(node.value) < 0) {
      node.left = add(node.left, value);
    } else if (value.compareTo(node.value) > 0) {
      node.right = add(node.right, value);
    }
    //更新高度值
    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    int balanceFactor = getBalanceFactor(node);
//    if (Math.abs(balanceFactor) > 1) {
//      System.out.println("失衡" + balanceFactor);
//      //维护平衡
//    }
    //LL
    if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
      return rightRotate(node);
    }
    //RR
    if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
      return leftRotate(node);
    }
    //LR
    if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    //RL
    if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }

    return node;
  }

  /**右旋转RR
   *                y                               x
   *              /  \                            /   \
   *            x     T4                         z     y
   *          /  \         -------------->     /  \   / \
   *        z     T3                         T1   T2 T3 T4
   *      /  \
   *    T1    T2
   * @param y
   * @return
   */
  private Node rightRotate(Node y) {
    Node x = y.left;
    y.left = x.right;
    x.right = y;
    //更新高度
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
    return x;
  }

  /**LL
   *         y                      x
   *       /  \                   /   \
   *      T1   x                 y     z
   *          / \              /  \   /  \
   *         T2  z            T1  T2 T3   T4
   *            / \
   *           T3  T4
   * @param y
   * @return
   */
  private Node leftRotate(Node y) {
    Node x = y.right;
    y.right = x.left;
    x.left = y;
    //更新高度
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
    return x;
  }

  //判断是否为二分搜索树
  public boolean isBST() {
    ArrayList<T> list = new ArrayList<>();
    inOrder(rootNode, list);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i - 1).compareTo(list.get(i)) > 0) {
        return false;
      }
    }
    return true;
  }

  private void inOrder(Node<T> node, List<T> list) {
    if (null == node) {
      return;
    }
    inOrder(node.left, list);
    list.add(node.value);
    inOrder(node.right, list);
  }

  public boolean isBalanced() {
    return isBalanced(rootNode);
  }

  //判断平衡
  private boolean isBalanced(Node<T> node) {
    if (null == node) {
      return true;
    }
    if (Math.abs(getBalanceFactor(node)) > 1) {
      return false;
    }
    return isBalanced(node.left) && isBalanced(node.right);
  }

  //查询
  public boolean contains(T value) {
    return contains(this.rootNode, value);
  }

  private boolean contains(Node<T> node, T value) {
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
    Stack<Node> stack = new Stack<>();
    stack.push(rootNode);
    while (!stack.empty()) {
      Node pop = stack.pop();
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
  private void preOrder(Node<T> node) {
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

  private void inOrder(Node<T> node) {
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

  private void postOrder(Node<T> node) {
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
    Queue<Node> queue = new LinkedList<>();
    queue.add(rootNode);
    while (!queue.isEmpty()) {
      Node remove = queue.remove();
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

  private Node<T> minimum(Node<T> node) {
    if (null == node || null == node.left) {
      return node;
    }
    return minimum(node.left);
  }

  public T removeMin() {
    T t = minimum();
    rootNode = removeMin(rootNode);
    return t;
  }

  private Node<T> removeMin(Node<T> node) {
    if (null == node.left) {
      Node<T> right = node.right;
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

  private Node<T> maximum(Node<T> node) {
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

  private Node<T> removeMax(Node<T> node) {
    if (null == node.right) {
      Node<T> left = node.left;
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

  private Node<T> remove(Node<T> node, T value) {
    if (null == node) {
      return null;
    }
    Node<T> result;
    if (value.compareTo(node.value) > 0) {
      node.right = remove(node.right, value);
      result = node;
    } else if (value.compareTo(node.value) < 0) {
      node.left = remove(node.left, value);
      result = node;
    } else {

      if (null == node.left) {
        result = node.right;
        node.right = null;
        size--;
      } else if (null == node.right) {
        result = node.left;
        node.left = null;
        size--;
      } else {

        result = minimum(node.right);
        result.right = remove(node.right, result.value);
        result.left = node.left;
        node.left = node.right = null;
      }
    }
    if (null == result) {
      return null;
    }
    //更新高度值
    result.height = 1 + Math.max(getHeight(result.left), getHeight(result.right));
    int balanceFactor = getBalanceFactor(result);
    if (Math.abs(balanceFactor) > 1) {
      System.out.println("失衡" + balanceFactor);
      //维护平衡
    }
    //LL
    if (balanceFactor > 1 && getBalanceFactor(result.left) >= 0) {
      return rightRotate(result);
    }
    //RR
    if (balanceFactor < -1 && getBalanceFactor(result.right) <= 0) {
      return leftRotate(result);
    }
    //LR
    if (balanceFactor > 1 && getBalanceFactor(result.left) < 0) {
      result.left = leftRotate(result.left);
      return rightRotate(result);
    }
    //RL
    if (balanceFactor < -1 && getBalanceFactor(result.right) > 0) {
      result.right = rightRotate(result.right);
      return leftRotate(result);
    }

    return result;
  }


  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    generateBSTString(this.rootNode, 0, builder);
    return builder.toString();
  }

  private void generateBSTString(Node<T> node, int depth, StringBuilder builder) {
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


  public class Node<T extends Comparable<T>> {

    private T value;
    private Node<T> left;
    private Node<T> right;
    private int height;

    public Node(T value) {
      this.value = value;
      this.left = null;
      this.right = null;
      this.height = 1;
    }

    public Node(T value, Node<T> left, Node<T> right) {
      this.value = value;
      this.left = left;
      this.right = right;
      this.height = 1;
    }
  }

}
