package com.wsx.play.graph.dfs;

/**
 * @Description 桥.
 * @Author:ShangxiuWu
 * @Date: 23:06 2020/7/29.
 * @Modified By:
 */

public class Edge {

  private int v;
  private int w;

  public Edge() {
  }

  public Edge(int v, int w) {
    this.v = v;
    this.w = w;
  }

  public int getV() {
    return v;
  }

  public void setV(int v) {
    this.v = v;
  }

  public int getW() {
    return w;
  }

  public void setW(int w) {
    this.w = w;
  }
}
