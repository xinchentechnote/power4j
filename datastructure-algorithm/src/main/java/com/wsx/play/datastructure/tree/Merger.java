package com.wsx.play.datastructure.tree;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 23:50 2020/7/6.
 * @Modified By:
 */
public interface Merger<E> {

  E merge(E a, E b);

}
