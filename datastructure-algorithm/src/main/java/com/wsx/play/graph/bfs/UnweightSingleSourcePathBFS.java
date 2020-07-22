package com.wsx.play.graph.bfs;

import com.wsx.play.graph.Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 广度优先遍历, 单元路径问题.
 * @Author:ShangxiuWu
 * @Date: 20:25 2020/7/22.
 * @Modified By:
 */
public class UnweightSingleSourcePathBFS {

  private Graph graph;
  /**访问标记.*/
  private boolean[] visited;
  private int source;
  private int[] pre;
  private int[] distance;


  public UnweightSingleSourcePathBFS(Graph graph, int source) {
    graph.validateVertex(source);

    this.source = source;
    this.graph = graph;
    visited = new boolean[graph.getVertex()];
    pre = new int[graph.getVertex()];
    distance = new int[graph.getVertex()];
    for (int i = 0; i < pre.length; i++) {
      pre[i] = -1;
      distance[i] = -1;
    }
    bfs(source);
  }

  public boolean isConnectedTo(int target) {
    graph.validateVertex(target);
    return visited[target];
  }

  public Iterable<Integer> path(int target) {
    List<Integer> result = new ArrayList<>();

    if (isConnectedTo(target)) {
      int cur = target;
      while (cur != source) {
        result.add(cur);
        cur = pre[cur];
      }
      result.add(source);
      Collections.reverse(result);
    }
    return result;
  }

  /**
   * 递归方法实现，TODO非递归实现，邻接矩阵深度优先遍历
   * @param s
   */
  private void bfs(int s) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    visited[s] = true;
    pre[s] = s;
    distance[s] = 0;
    while (!queue.isEmpty()) {
      Integer v = queue.remove();
      for (int w : graph.adjacencyVertex(v)) {
        if (!visited[w]) {
          queue.add(w);
          visited[w] = true;
          pre[w] = v;
          distance[w] = distance[v] + 1;
        }
      }
    }
    System.out.println(Arrays.toString(distance));
  }


  public static void main(String[] args) {
    Graph g = new Graph("H:\\workspace\\power4j\\datastructure-algorithm\\bfs.txt");
    UnweightSingleSourcePathBFS bfs = new UnweightSingleSourcePathBFS(g, 0);
    System.out.println(bfs.isConnectedTo(5));
    System.out.println(bfs.path(5));
  }

}
