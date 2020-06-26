package com.wsx.play.datastructure;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午8:51 2020/6/26.
 * @Modified By:
 */
public interface Queue<E> {

  void enqueue(E e);

  E dequeue();

  E getFront();

  int getSize();

  boolean isEmpty();

}
