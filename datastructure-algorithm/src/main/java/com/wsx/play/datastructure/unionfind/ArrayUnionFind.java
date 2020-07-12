package com.wsx.play.datastructure.unionfind;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 8:37 2020/7/12.
 * @Modified By:
 */
public class ArrayUnionFind implements UnionFind {

  private int[] ids;

  public ArrayUnionFind(int size) {
    ids = new int[size];
    for (int i = 0; i < ids.length; i++) {
      ids[i] = i;
    }
  }

  @Override
  public int getSize() {
    return this.ids.length;
  }

  @Override
  public boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }

  private int find(int index) {
    if (index < 0 || index >= ids.length) {
      throw new IllegalArgumentException("index is illegal.");
    }
    return ids[index];
  }

  @Override
  public void unionElement(int p, int q) {
    if (isConnected(p,q)){
      return;
    }
    int id = find(q);
    for (int i = 0; i < ids.length; i++) {
      if (ids[i] == id) {
        ids[i] = ids[p];
      }
    }
  }
}
