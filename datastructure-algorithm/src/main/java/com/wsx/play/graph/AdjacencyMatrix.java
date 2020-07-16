package com.wsx.play.graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.midi.Soundbank;

/**
 * @Description 邻接矩阵（二位数组矩阵）.
 * @Author:ShangxiuWu
 * @Date: 19:22 2020/7/5.
 * @Modified By:
 */
public class AdjacencyMatrix {

  /**顶点数.*/
  private int vertex;
  /**边数.*/
  private int edge;
  /**矩阵.*/
  private int[][] adjacency;

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
  public AdjacencyMatrix(String filePath) {
    File file = new File(filePath);
    try (Scanner scanner = new Scanner(file)) {
      vertex = scanner.nextInt();
      if (vertex < 0) {
        throw new IllegalArgumentException("vertex must be non-negative.");
      }
      adjacency = new int[vertex][vertex];
      edge = scanner.nextInt();
      if (edge < 0) {
        throw new IllegalArgumentException("edge must be non-negative.");
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
        if (adjacency[a][b] == 1) {
          throw new IllegalArgumentException("parallel edge is detected.");
        }
        adjacency[a][b] = 1;
        adjacency[b][a] = 1;
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
    return adjacency[v][w] == 1;
  }

  /**
   * 顶点v的相邻顶点
   * @param v
   * @return
   */
  public List<Integer> adjacencyVertex(int v) {
    validateVertex(v);
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < vertex; i++) {
      if (adjacency[v][i] == 1) {
        result.add(i);
      }
    }
    return result;
  }

  /**
   * 顶点v的度
   * @param v
   * @return
   */
  public int degree(int v) {
    return adjacencyVertex(v).size();
  }

  private void validateVertex(int v) {
    if (v < 0 || v >= vertex) {
      throw new IllegalArgumentException("vertex " + v + " is valid.");
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("vertex:").append(vertex).append(",edge:").append(edge).append("\n");
    for (int i = 0; i < vertex; i++) {
      for (int j = 0; j < vertex; j++) {
        builder.append(String.format("%d ", adjacency[i][j]));
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    String filePath = "H:\\workspace\\power4j\\datastructure-algorithm\\graph1.txt";
    AdjacencyMatrix matrix = new AdjacencyMatrix(filePath);
    System.out.println(matrix);
  }
}
