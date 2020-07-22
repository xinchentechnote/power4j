package com.wsx.play.graph.dfs;

import com.wsx.play.graph.Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 深度优先遍历，联通分量.
 * @Author:ShangxiuWu
 * @Date: 20:25 2020/7/22.
 * @Modified By:
 */
public class GraphConnectedComponent {

  private Graph graph;
  /**访问标记.*/
  private int[] visited;
  /**联通分量.*/
  private int connectedComponentCount;

  private List<Integer> preOrder = new ArrayList<>();
  private List<Integer> postOrder = new ArrayList<>();

  public GraphConnectedComponent(Graph graph) {
    this.graph = graph;
    visited = new int[graph.getVertex()];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = -1;
    }
    for (int v = 0; v < graph.getVertex(); v++) {
      if (visited[v] == -1) {
        dfs(v, connectedComponentCount);
        connectedComponentCount++;
      }
    }
  }

  /**
   * 联通分量个数
   * @return
   */
  public int getConnectedComponentCount() {
    System.out.println(Arrays.toString(visited));
    return connectedComponentCount;
  }

  /**
   * 联通分量包含的顶点
   * @return
   */
  public List<Integer>[] components() {
    List<Integer>[] res = new ArrayList[connectedComponentCount];
    for (int i = 0; i < connectedComponentCount; i++) {
      res[i] = new ArrayList<>();
    }
    for (int v = 0; v < graph.getVertex(); v++) {
      res[visited[v]].add(v);
    }
    return res;
  }

  /**
   * 递归方法实现，TODO非递归实现，邻接矩阵深度优先遍历
   * @param v
   */
  private void dfs(int v, int connectedComponent) {
    visited[v] = connectedComponent;
    //先序遍历
    preOrder.add(v);
    for (int w : graph.adjacencyVertex(v)) {
      if (visited[w] == -1) {
        dfs(w, connectedComponent);
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

  /**
   * 是否联通
   * @param v
   * @param w
   * @return
   */
  public boolean isConnected(int v, int w) {
    graph.validateVertex(v);
    graph.validateVertex(w);
    return visited[v] == visited[w];
  }


  public static void main(String[] args) {
    Graph g = new Graph("H:\\workspace\\power4j\\datastructure-algorithm\\cc.txt");
    GraphConnectedComponent dfs = new GraphConnectedComponent(g);
    Iterable<Integer> preOrder = dfs.preOrder();
    Iterable<Integer> postOrder = dfs.postOrder();
    System.out.println(preOrder);
    System.out.println(postOrder);
    System.out.println(dfs.getConnectedComponentCount());
    System.out.println(dfs.isConnected(0, 5));
    System.out.println(dfs.isConnected(0, 6));
    System.out.println(dfs.isConnected(1, 5));
    System.out.println(Arrays.toString(dfs.components()));
  }

}
