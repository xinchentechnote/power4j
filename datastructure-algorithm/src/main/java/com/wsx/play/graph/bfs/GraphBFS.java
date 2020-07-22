package com.wsx.play.graph.bfs;

import com.wsx.play.graph.Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 广度优先遍历.
 * @Author:ShangxiuWu
 * @Date: 20:25 2020/7/22.
 * @Modified By:
 */
public class GraphBFS {

  private Graph graph;
  /**访问标记.*/
  private boolean[] visited;

  private List<Integer> order = new ArrayList<>();

  public GraphBFS(Graph graph) {
    this.graph = graph;
    visited = new boolean[graph.getVertex()];
    for (int v = 0; v < graph.getVertex(); v++) {
      if (!visited[v]) {
        bfs(v);
      }
    }
  }


  /**
   * 递归方法实现，TODO非递归实现，邻接矩阵深度优先遍历
   * @param v
   */
  private void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      Integer remove = queue.remove();
      order.add(remove);
      for (int w : graph.adjacencyVertex(remove)) {
        if (!visited[w]) {
          queue.add(w);
          visited[w] = true;
        }
      }
    }
  }

  public Iterable<Integer> order() {
    return order;
  }


  public static void main(String[] args) {
    Graph g = new Graph("H:\\workspace\\power4j\\datastructure-algorithm\\bfs.txt");
    GraphBFS dfs = new GraphBFS(g);
    Iterable<Integer> order = dfs.order();
    System.out.println(order);
  }

}
