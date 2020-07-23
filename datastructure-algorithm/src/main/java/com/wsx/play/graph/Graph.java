package com.wsx.play.graph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Description 邻接表（TreeSet）.使用HashSet、TreeSet
 * @Author:ShangxiuWu
 * @Date: 19:24 2020/7/5.
 * @Modified By:
 */
public class Graph {


  /**顶点数.*/
  private int vertex;
  /**边数.*/
  private int edge;
  /**矩阵.*/
  private TreeSet<Integer>[] adjacency;


  public int getVertex() {
    return vertex;
  }

  public int getEdge() {
    return edge;
  }

  /**
   * 构建邻接矩阵
   * @param filePath
   */
  public Graph(String filePath) {
    File file = new File(filePath);
    try (Scanner scanner = new Scanner(file)) {
      vertex = scanner.nextInt();
      if (vertex < 0) {
        throw new IllegalArgumentException("vertex must be non-negative.");
      }
      adjacency = new TreeSet[vertex];
      edge = scanner.nextInt();
      if (edge < 0) {
        throw new IllegalArgumentException("edge must be non-negative.");
      }
      for (int i = 0; i < vertex; i++) {
        adjacency[i] = new TreeSet<>();
      }
      for (int i = 0; i < edge; i++) {
        int a = scanner.nextInt();
        validateVertex(a);
        int b = scanner.nextInt();
        validateVertex(b);
        //自环边
        if (a == b) {
          throw new IllegalArgumentException("self loop is detected.");
        }
        //平行边
        if (adjacency[a].contains(b)) {
          throw new IllegalArgumentException("parallel edge is detected.");
        }
        adjacency[a].add(b);
        adjacency[b].add(a);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 连个顶点是否联通
   * @param v
   * @param w
   * @return
   */
  public boolean hasEdge(int v, int w) {
    validateVertex(v);
    validateVertex(w);
    return adjacency[v].contains(w);
  }

  /**
   * 顶点v的相邻顶点
   * @param v
   * @return
   */
  public Iterable<Integer> adjacencyVertex(int v) {
    validateVertex(v);
    return adjacency[v];
  }

  /**
   * 顶点v的度
   * @param v
   * @return
   */
  public int degree(int v) {
    validateVertex(v);
    return adjacency[v].size();
  }

  public void validateVertex(int v) {
    if (v < 0 || v >= vertex) {
      throw new IllegalArgumentException("vertex " + v + " is valid.");
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("vertex:").append(vertex).append(",edge:").append(edge).append("\n");
    for (int i = 0; i < vertex; i++) {
      builder.append(i).append(" : ");
      for (int w : adjacency[i]) {
        builder.append(String.format("%d ", w));
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    String filePath = "H:\\workspace\\power4j\\datastructure-algorithm\\graph1.txt";
    Graph matrix = new Graph(filePath);
    System.out.println(matrix);
  }
}
