package com.wsx.play.graph.dfs;

import com.wsx.play.graph.Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 深度优先遍历，单源路径问题.
 * @Author:ShangxiuWu
 * @Date: 20:25 2020/7/22.
 * @Modified By:
 */
public class SingleSourcePath {

  private Graph graph;
  private int source;
  /**访问标记.*/
  private int[] pre;


  public SingleSourcePath(Graph graph, int source) {
    this.graph = graph;
    this.source = source;
    pre = new int[graph.getVertex()];
    for (int i = 0; i < pre.length; i++) {
      pre[i] = -1;
    }
    dfs(source, source);
  }


  /**
   * 递归方法实现，TODO非递归实现，邻接矩阵深度优先遍历
   * @param v
   */
  private void dfs(int v, int parent) {
    pre[v] = parent;
    //先序遍历
    for (int w : graph.adjacencyVertex(v)) {
      if (pre[w] == -1) {
        dfs(w, v);
      }
    }
    //后序遍历
  }

  /**
   * 是否联通
   * @param target
   * @return
   */
  public boolean isConnectTo(int target) {
    graph.validateVertex(target);
    return pre[target] != -1;
  }

  /**
   * 联通路径
   * @param target
   * @return
   */
  public Iterable<Integer> path(int target) {
    List<Integer> path = new ArrayList<>();
    if (!isConnectTo(target)) {
      return path;
    }
    int cur = target;
    while (cur != source) {
      path.add(cur);
      cur = pre[cur];
    }
    path.add(source);
    Collections.reverse(path);
    return path;
  }


  public static void main(String[] args) {
    Graph g = new Graph("H:\\workspace\\power4j\\datastructure-algorithm\\g.txt");
    SingleSourcePath dfs = new SingleSourcePath(g, 0);
    System.out.println(dfs.path(6));
    System.out.println(dfs.path(5));
  }

}
