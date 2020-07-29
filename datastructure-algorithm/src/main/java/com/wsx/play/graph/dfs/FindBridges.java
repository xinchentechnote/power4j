package com.wsx.play.graph.dfs;

import com.wsx.play.graph.Graph;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 寻找桥.
 * @Author:ShangxiuWu
 * @Date: 22:36 2020/7/29.
 * @Modified By:
 */
public class FindBridges {

  private Graph graph;
  private boolean[] visited;

  private int[] order;
  private int[] low;
  private int cnt;

  private List<Edge> res;

  public FindBridges(Graph graph) {
    this.graph = graph;
    visited = new boolean[graph.getVertex()];
    res = new ArrayList<>();
    //遍历顺序
    order = new int[graph.getVertex()];
    low = new int[graph.getVertex()];
    cnt = 0;

    for (int v = 0; v < graph.getVertex(); v++) {
      if (!visited[v]) {
        dfs(v, v);
      }
    }
  }

  private void dfs(int v, int parent) {
    visited[v] = true;
    order[v] = cnt;
    low[v] = order[v];
    cnt++;
    for (int w : graph.adjacencyVertex(v)) {
      if (!visited[w]) {
        dfs(w, v);
        low[v] = Math.min(low[v], low[w]);
        if (low[w] > order[v]) {
          res.add(new Edge(v, w));
        } else if (w != parent) {
          low[v] = Math.min(low[v], low[w]);
        }
      }
    }
  }


  public List<Edge> result() {
    return res;
  }
}
