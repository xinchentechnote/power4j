package com.wsx.play.datastructure.tree;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 15:07 2020/7/5.
 * @Modified By:
 */
public interface Set<E> {

  void add(E e);

  void remove(E e);

  boolean contains(E e);

  int getSize();

  boolean isEmpty();

}
