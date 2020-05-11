package com.wsx.mrhan;


/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 10:46 2020/5/11.
 * @Modified By:
 */
public class LinkedList<E> {

  private Node<E> head;

  public LinkedList() {
    head = new Node<>(null, null);
  }

  /**
   *@Description 添加元素.
   *@params
   *@return
   *@Author wusx
   *@Date 11:23 2020/5/11
   *@Modified
   */
  public void add(E e) {
    Node<E> temp = head;
    while (null != temp.next) {
      temp = temp.next;
    }
    temp.next = new Node<>(e, null);
  }

  /**
   *@Description 删除元素.
   *@params
   *@return
   *@Author wusx
   *@Date 11:38 2020/5/11
   *@Modified
   */
  public void remove(E e) {
    Node<E> prev = head;
    Node<E> temp = head.next;
    while (null != temp) {
      if (temp.item.equals(e)) {
        prev.next = temp.next;
        break;
      } else {
        prev = temp;
        temp = temp.next;
      }

    }
  }

  //改
  //查
  //show
  public void show() {
    Node<E> temp = head;
    while (null != temp.next) {
      temp = temp.next;
      System.out.println(temp.item + "-->");
    }

  }

  private static class Node<E> {

    E item;
    Node<E> next;

    Node(E element, Node<E> next) {
      this.item = element;
      this.next = next;
    }


  }

  public static void main(String[] args) {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("1");
    linkedList.add("2");
    linkedList.add("3");
    linkedList.show();
    linkedList.remove("2");
    linkedList.show();
  }

}
