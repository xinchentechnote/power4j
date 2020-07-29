package com.wsx.play.graph.dfs;

import com.wsx.play.graph.Graph;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 寻找割点.
 * @Author:ShangxiuWu
 * @Date: 22:36 2020/7/29.
 * @Modified By:
 */
public class FindCutPoints {

  private Graph graph;
  private boolean[] visited;

  private int[] order;
  private int[] low;
  private int cnt;

  private List<Integer> res;

  public FindCutPoints(Graph graph) {
    this.graph = graph;
    visited = new boolean[graph.getVertex()];
    res = new ArrayList<>();
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
    int child = 0;
    for (int w : graph.adjacencyVertex(v)) {
      if (!visited[w]) {
        dfs(w, v);
        low[v] = Math.min(low[v], low[w]);
        if (v != parent && low[w] >= order[v]) {
          res.add(v);
        }
        child++;
        if (v == parent && child > 1) {
          res.add(v);
        }
      } else if (w != parent) {
        low[v] = Math.min(low[v], low[w]);
      }
    }
  }


  public List<Integer> result() {
    return res;
  }
}
