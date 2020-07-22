package com.wsx.play.graph;

/**
 * @Description 二分图检测，染色.
 * @Author:ShangxiuWu
 * @Date: 20:25 2020/7/22.
 * @Modified By:
 */
public class BipartitionDetection {

  private Graph graph;
  /**访问标记.*/
  private boolean[] visited;
  private int[] colors;
  private boolean isBipartition = true;


  public BipartitionDetection(Graph graph) {
    this.graph = graph;
    visited = new boolean[graph.getVertex()];
    colors = new int[graph.getVertex()];
    for (int i = 0; i < colors.length; i++) {
      colors[i] = -1;
    }
    for (int v = 0; v < graph.getVertex(); v++) {
      if (!visited[v]) {
        if (!dfs(v, 0)) {
          isBipartition = false;
          break;
        }
      }
    }
  }


  /**
   * 递归方法实现，TODO非递归实现，邻接矩阵深度优先遍历
   * @param v
   */
  private boolean dfs(int v, int color) {
    visited[v] = true;
    colors[v] = color;
    for (int w : graph.adjacencyVertex(v)) {
      if (!visited[w]) {
        if (!dfs(w, 1 - color)) {
          return false;
        }
      } else if (colors[w] == colors[v]) {
        return false;
      }
    }
    return true;
  }

  /**
   * 是否为二分图
   * @return
   */
  public boolean isBipartition() {
    return isBipartition;
  }

  public static void main(String[] args) {
    Graph g = new Graph("H:\\workspace\\power4j\\datastructure-algorithm\\g3.txt");
    BipartitionDetection dfs = new BipartitionDetection(g);
    System.out.println(dfs.isBipartition());
  }

}
