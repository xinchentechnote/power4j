package com.wsx.play.datastructure.tree;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:51 2020/6/21.
 * @Modified By:
 */
public class BSTree<T extends Comparable<T>> {


  public static void main(String[] args) {

  }

  private BSTNode<T> rootNode;

  public BSTree(BSTNode<T> rootNode) {
    this.rootNode = rootNode;
  }

  public class BSTNode<T extends Comparable<T>> {

    private T value;
    private BSTNode<T> left;
    private BSTNode<T> right;
    private BSTNode<T> parent;

    public BSTNode(T value, BSTNode<T> left, BSTNode<T> right,
        BSTNode<T> parent) {
      this.value = value;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }

    //前序遍历
    public void preOrderTraverse() {
      System.out.println(value);
      if (null != left) {
        left.preOrderTraverse();
      }
      if (null != right) {
        right.preOrderTraverse();
      }
    }

    //中序遍历
    public void inOrderTraverse() {
      if (null != left) {
        left.inOrderTraverse();
      }
      System.out.println(value);
      if (null != right) {
        right.inOrderTraverse();
      }
    }

    //后序遍历
    public void postOrderTraverse() {
      if (null != left) {
        left.postOrderTraverse();
      }
      if (null != right) {
        right.postOrderTraverse();
      }
      System.out.println(value);
    }
  }

}
