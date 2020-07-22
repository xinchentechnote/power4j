package com.wsx.play.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 深度优先遍历.
 * @Author:ShangxiuWu
 * @Date: 20:25 2020/7/22.
 * @Modified By:
 */
public class GraphDFS {

  private Graph graph;
  /**访问标记.*/
  private boolean[] visited;
  /**联通分量.*/
  private int connectedComponent;

  private List<Integer> preOrder = new ArrayList<>();
  private List<Integer> postOrder = new ArrayList<>();

  public GraphDFS(Graph graph) {
    this.graph = graph;
    visited = new boolean[graph.getVertex()];
    for (int v = 0; v < graph.getVertex(); v++) {
      if (!visited[v]) {
        dfs(v);
        connectedComponent++;
      }
    }
  }

  public int getConnectedComponent() {
    return connectedComponent;
  }

  /**
   * 递归方法实现，TODO非递归实现，邻接矩阵深度优先遍历
   * @param v
   */
  private void dfs(int v) {
    visited[v] = true;
    //先序遍历
    preOrder.add(v);
    for (int w : graph.adjacencyVertex(v)) {
      if (!visited[w]) {
        dfs(w);
      }
    }
    //后序遍历
    postOrder.add(v);
  }

  public Iterable<Integer> preOrder() {
    return preOrder;
  }

  public Iterable<Integer> postOrder() {
    return postOrder;
  }


  public static void main(String[] args) {
    Graph g = new Graph("H:\\workspace\\power4j\\datastructure-algorithm\\g.txt");
    GraphDFS dfs = new GraphDFS(g);
    Iterable<Integer> preOrder = dfs.preOrder();
    Iterable<Integer> postOrder = dfs.postOrder();
    System.out.println(preOrder);
    System.out.println(postOrder);
    System.out.println(dfs.getConnectedComponent());
  }

}
