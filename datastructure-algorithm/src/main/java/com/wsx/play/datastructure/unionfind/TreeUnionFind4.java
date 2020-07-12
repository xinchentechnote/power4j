package com.wsx.play.datastructure.unionfind;

/**
 * @Description 基于size优化、基于rank优化.
 * @Author:ShangxiuWu
 * @Date: 9:03 2020/7/12.
 * @Modified By:
 */
public class TreeUnionFind4 implements UnionFind {

  private int[] parent;
  //基于rank优化
  private int[] rank;

  public TreeUnionFind4(int size) {
    this.parent = new int[size];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  private int find(int p) {
    if (p < 0 || p >= parent.length) {
      throw new IllegalArgumentException("p is out of bound.");
    }
    if (p != parent[p]) {
      //基于路径压缩优化并查集,直接挂到根阶段
      parent[p] = find(parent[p]);
      p = parent[p];
    }
    return p;
  }

  @Override
  public int getSize() {
    return parent.length;
  }

  @Override
  public boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   *@Description 基于rank优化.
   *@Author wusx
   *@Date 9:57 2020/7/12
   *@Modified
   */
  @Override
  public void unionElement(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) {
      return;
    }
    if (rank[pRoot] < rank[qRoot]) {
      parent[pRoot] = qRoot;
    } else if (rank[pRoot] > rank[qRoot]) {
      parent[qRoot] = pRoot;
    } else {
      parent[qRoot] = pRoot;
      rank[pRoot] += 1;
    }
  }

}
