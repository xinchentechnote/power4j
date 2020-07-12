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
public class AVLTree<K extends Comparable<K>, V> {


  public static void main(String[] args) {

    AVLTree<Integer, Integer> bst = new AVLTree<>();
    int[] data = new int[]{1, 2, 3, 4, 5, 6, 10, 9, 8, 7};
    for (int i = 0; i < data.length; i++) {
      bst.add(data[i], data[i]);
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

  private Node<K, V> rootNode;

  private int size;

  public AVLTree() {
    this.rootNode = null;
    this.size = 0;
  }

  public AVLTree(Node<K, V> rootNode) {
    this.rootNode = rootNode;
    this.size++;
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public V get(K key) {
    Node<K, V> node = getNode(rootNode, key);
    if (null != node) {
      return node.value;
    }
    return null;
  }

  private Node<K, V> getNode(Node<K, V> node, K key) {
    if (null == node) {
      return null;
    }
    if (key.compareTo(node.key) == 0) {
      return node;
    } else if (key.compareTo(node.key) > 0) {
      return getNode(node.right, key);
    } else {
      return getNode(node.left, key);
    }
  }

  public void set(K key, V value) {
    Node<K, V> node = getNode(rootNode, key);
    if (null != node) {
      node.value = value;
    }
  }

  /**
   *@Description 获取节点的高度.
   *@Author wusx
   *@Date 10:32 2020/7/12
   *@Modified
   */
  private int getHeight(Node<K, V> node) {
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
  private int getBalanceFactor(Node<K, V> node) {
    return getHeight(node.left) - getHeight(node.right);
  }

  public void add(K key, V value) {
    this.rootNode = add(rootNode, key, value);
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
    } else {
      node.value = value;
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
    ArrayList<K> list = new ArrayList<>();
    inOrder(rootNode, list);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i - 1).compareTo(list.get(i)) > 0) {
        return false;
      }
    }
    return true;
  }

  private void inOrder(Node<K, V> node, List<K> list) {
    if (null == node) {
      return;
    }
    inOrder(node.left, list);
    list.add(node.key);
    inOrder(node.right, list);
  }

  public boolean isBalanced() {
    return isBalanced(rootNode);
  }

  //判断平衡
  private boolean isBalanced(Node<K, V> node) {
    if (null == node) {
      return true;
    }
    if (Math.abs(getBalanceFactor(node)) > 1) {
      return false;
    }
    return isBalanced(node.left) && isBalanced(node.right);
  }

  //查询
  public boolean contains(K key) {
    return contains(this.rootNode, key);
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
    preOrder(this.rootNode);
    System.out.println();
  }

  //非递归前序遍历
  public void preOrderNR() {
    Stack<Node> stack = new Stack<>();
    stack.push(rootNode);
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
    inOrder(this.rootNode);
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
    postOrder(this.rootNode);
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
    queue.add(rootNode);
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
    return minimum(rootNode).key;
  }

  private Node<K, V> minimum(Node<K, V> node) {
    if (null == node || null == node.left) {
      return node;
    }
    return minimum(node.left);
  }

  public K removeMin() {
    K k = minimum();
    rootNode = removeMin(rootNode);
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
    return maximum(rootNode).key;
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
    rootNode = removeMax(rootNode);
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
  public V remove(K key) {
    Node<K, V> node = getNode(rootNode, key);
    if (null != node) {
      rootNode = remove(rootNode, key);
      return node.value;
    }
    return null;
  }

  private Node<K, V> remove(Node<K, V> node, K value) {
    if (null == node) {
      return null;
    }
    Node<K, V> result;
    if (value.compareTo(node.key) > 0) {
      node.right = remove(node.right, value);
      result = node;
    } else if (value.compareTo(node.key) < 0) {
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
        result.right = remove(node.right, result.key);
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


  public class Node<K extends Comparable<K>, V> {

    private K key;
    private V value;
    private Node<K, V> left;
    private Node<K, V> right;
    private int height;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
      this.height = 1;
    }

    public Node(K key, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
      this.height = 1;
    }
  }

}
