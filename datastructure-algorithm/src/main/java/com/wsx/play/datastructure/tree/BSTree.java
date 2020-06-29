package com.wsx.play.datastructure.tree;

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
    System.out.println(bst);
    bst.preOrder();
    //排序
    bst.inOrder();
    bst.postOrder();

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

  //递归遍历
  public void preOrder() {
    preOrder(this.rootNode);
    System.out.println();
  }

  //前序遍历
  private void preOrder(BSTNode<T> node) {
    if (null == node) {
      return;
    }
    System.out.print(node.value+" ");
    preOrder(node.left);
    preOrder(node.right);
  }


  //中序遍历
  public void inOrder() {
    inOrder(this.rootNode);
    System.out.println();
  }

  private void inOrder(BSTNode<T> node) {
    if (null == node) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.value+" ");
    inOrder(node.right);
  }

  //后序遍历
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
    System.out.print(node.value+" ");
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
    generateBSTString(node.left,depth+1,builder);
    generateBSTString(node.right,depth+1,builder);
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
