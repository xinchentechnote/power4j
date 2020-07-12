package com.wsx.play.datastructure.unionfind;

/**
 * @Description 并查集.
 * @Author:ShangxiuWu
 * @Date: 0:12 2020/7/12.
 * @Modified By:
 */
public interface UnionFind {

  int getSize();

  boolean isConnected(int p, int q);

  void unionElement(int p, int q);
}
