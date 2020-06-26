package com.wsx.play.datastructure;

import sun.net.idn.Punycode;

/**
 * @Description 数据结构：栈（LIFO）.
 * @Author:ShangxiuWu
 * @Date: 下午11:46 2020/6/26.
 * @Modified By:
 */
public interface Stack<E> {


  public void push(E e);

  public E pop();

  public E peek();

  public int getSize();

  public boolean isEmpty();

}
