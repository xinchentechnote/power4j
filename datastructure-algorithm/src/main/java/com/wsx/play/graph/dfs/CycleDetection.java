package com.wsx.play.graph.dfs;

import com.wsx.play.graph.Graph;

/**
 * @Description 深度优先遍历，环检测.
 * @Author:ShangxiuWu
 * @Date: 20:25 2020/7/22.
 * @Modified By:
 */
public class CycleDetection {

  private Graph graph;
  /**访问标记.*/
  private boolean[] visited;
  /**是否有环.*/
  private boolean hasCycle;

  public CycleDetection(Graph graph) {
    this.graph = graph;
    visited = new boolean[graph.getVertex()];
    for (int v = 0; v < graph.getVertex(); v++) {
      if (!visited[v]) {
        if (dfs(v, v)) {
          hasCycle = true;
          //提前終止
          break;
        }
      }
    }
  }

  /**
   * 递归方法实现，TODO非递归实现，邻接矩阵深度优先遍历
   * @param v
   */
  private boolean dfs(int v, int parent) {
    visited[v] = true;
    for (int w : graph.adjacencyVertex(v)) {
      if (!visited[w]) {
        if (dfs(w, v)) {
          return true;
        }
      } else if (w != parent) {
        return true;
      }
    }
    return false;
  }

  public boolean isHasCycle() {
    return hasCycle;
  }

  public static void main(String[] args) {
    Graph g = new Graph("H:\\workspace\\power4j\\datastructure-algorithm\\g2.txt");
    CycleDetection dfs = new CycleDetection(g);
    System.out.println(dfs.isHasCycle());
  }

}
