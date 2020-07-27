package com.wsx.leetcode.editor.en;

//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (r
//epresenting land) connected 4-directionally (horizontal or vertical.) You may as
//sume all four edges of the grid are surrounded by water. 
//
// Find the maximum area of an island in the given 2D array. (If there is no isl
//and, the maximum area is 0.) 
//
// Example 1: 
//
// 
//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//Given the above grid, return 6. Note the answer is not 11, because the island 
//must be connected 4-directionally.
//
// Example 2: 
//
// 
//[[0,0,0,0,0,0,0,0]] 
//Given the above grid, return 0.
//
// Note: The length of each dimension in the given grid does not exceed 50. 
// Related Topics Array Depth-first Search 
// 👍 1969 👎 79

//Java：Max Area of Island

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 二维数组转以为数组
 * 求图的最大的联通分量
 * 四联通
 * [[-1,0],[0,1]
 * [1,0],[0,-1]]
 * 八联通
 * [[-1,0],[-1,-1],[0,-1],[1,-1]
 * [-1,1],[0,1],[1,1],[1,0]]
 * floodfill算法
 */
public class Q695MaxAreaOfIsland {

  public static void main(String[] args) {
    Solution solution = new Solution();
    // TO TEST
//    int[][] data = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
    int[][] data = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
    int areaOfIsland = solution.maxAreaOfIsland(data);
    System.out.println(areaOfIsland);
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    /** 行数.*/
    private int R;
    /** 列数.*/
    private int C;
    /** 原始矩阵.*/
    private int[][] grid;
    /** 四联通.*/
    private int[][] dirs = {{-1, 0}, {0, 1},
        {1, 0}, {0, -1}};
    /** 访问标记.*/
    boolean[][] visited;

    /**
     * 最大岛屿面积（最大联通分量）
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
      if (null == grid) {
        return 0;
      }
      if (grid.length == 0) {
        return 0;
      }
      if (grid[0].length == 0) {
        return 0;
      }
      this.R = grid.length;
      this.C = grid[0].length;
      this.visited = new boolean[R][C];

      this.grid = grid;
      int result = 0;
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (!visited[i][j] && grid[i][j] == 1) {
            //求最大联通分量
            result = Math.max(result, dfs(i, j));
          }
        }

      }
      return result;
    }

    /**
     * 深度优先遍历
     * @param i
     */
    private int dfs(int i, int j) {
      int res = 1;
      visited[i][j] = true;
      for (int d = 0; d < 4; d++) {
        int nextX = i + dirs[d][0];
        int nextY = j + dirs[d][1];
        if (inArea(nextX, nextY) &&!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
          res += dfs(nextX, nextY);
        }
      }
      return res;
    }

    /**
     * 判断下标是否在矩阵内
     * @param nextX
     * @param nextY
     * @return
     */
    private boolean inArea(int nextX, int nextY) {
      return nextX >= 0 && nextX < R && nextY >= 0 && nextY < C;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

  /**
   * 第二次实现，直接求最大两通分量个数
   */
  class Solution2 {

    /** 行数.*/
    private int R;
    /** 列数.*/
    private int C;
    /** 原始矩阵.*/
    private int[][] grid;
    /** 邻接表表示的图.*/
    private TreeSet<Integer>[] graph;
    /** 四联通.*/
    private int[][] dirs = {{-1, 0}, {0, 1},
        {1, 0}, {0, -1}};
    /** 访问标记.*/
    boolean[] visited;

    /**
     * 最大岛屿面积（最大联通分量）
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
      if (null == grid) {
        return 0;
      }
      if (grid.length == 0) {
        return 0;
      }
      if (grid[0].length == 0) {
        return 0;
      }
      this.R = grid.length;
      this.C = grid[0].length;
      this.visited = new boolean[R * C];

      this.grid = grid;
      this.graph = constructGraph();
      int result = 0;
      for (int i = 0; i < graph.length; i++) {
        if (!visited[i] && grid[i / C][i % C] == 1) {
          //求最大联通分量
          result = Math.max(result, dfs(i));
        }
      }
      return result;
    }

    /**
     * 深度优先遍历
     * @param v
     */
    private int dfs(int v) {
      int res = 1;
      visited[v] = true;
      for (Integer w : graph[v]) {
        if (!visited[w] && grid[w / C][w % C] == 1) {
          res += dfs(w);
        }
      }
      return res;
    }

    /**
     * 构建图对应的邻接表
     * @return
     */
    private TreeSet<Integer>[] constructGraph() {
      TreeSet<Integer>[] g = new TreeSet[R * C];
      for (int i = 0; i < g.length; i++) {
        g[i] = new TreeSet<>();
      }
      for (int v = 0; v < g.length; v++) {
        //一维数组转二维
        int x = v / C, y = v % C;
        if (grid[x][y] == 1) {
          for (int d = 0; d < dirs.length; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && grid[nextX][nextY] == 1) {
              //二维数组转一维
              int e = nextX * C + nextY;
              g[v].add(e);
              //无向图
              g[e].add(v);
            }
          }
        }
      }
      return g;
    }

    /**
     * 判断下标是否在矩阵内
     * @param nextX
     * @param nextY
     * @return
     */
    private boolean inArea(int nextX, int nextY) {
      return nextX >= 0 && nextX < R && nextY >= 0 && nextY < C;
    }
  }

  /**
   * 第一次实现，计算了多余的联通分量
   */
  class Solution3 {

    /** 行数.*/
    private int R;
    /** 列数.*/
    private int C;
    /** 原始矩阵.*/
    private int[][] grid;
    /** 邻接表表示的图.*/
    private TreeSet<Integer>[] graph;
    /** 四联通.*/
    private int[][] dirs = {{-1, 0}, {0, 1},
        {1, 0}, {0, -1}};
    /** 访问标记.*/
    int[] visited;

    /**
     * 最大岛屿面积（最大联通分量）
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
      if (null == grid) {
        return 0;
      }
      if (grid.length == 0) {
        return 0;
      }
      if (grid[0].length == 0) {
        return 0;
      }
      this.R = grid.length;
      this.C = grid[0].length;
      this.visited = new int[R * C];
      for (int i = 0; i < visited.length; i++) {
        visited[i] = -1;
      }
      this.grid = grid;
      this.graph = constructGraph();

      //求最大联通分量
      return maximumCommutationComponent();
    }

    private int maximumCommutationComponent() {
      int commutationComponent = 0;
      //深度遍历
      for (int i = 0; i < graph.length; i++) {
        if (visited[i] == -1 && grid[i / R][i % C] == 1) {
          dfs(i, commutationComponent++);
        }
      }
      //求联通分量顶点
      ArrayList<Integer>[] res = new ArrayList[commutationComponent + 1];
      for (int i = 0; i < res.length; i++) {
        res[i] = new ArrayList<>();
      }
      for (int i = 0; i < visited.length; i++) {
        res[visited[i]].add(i);
      }
      //获取最大联通分量顶点数
      int maxArea = 0;
      for (int i = 0; i < res.length; i++) {
        int size = res[i].size();
        if (size > maxArea) {
          maxArea = size;
        }
      }
      return maxArea;
    }

    /**
     * 深度优先遍历
     * @param v
     * @param commutationComponent
     */
    private void dfs(int v, int commutationComponent) {
      visited[v] = commutationComponent;
      for (Integer w : graph[v]) {
        if (visited[w] == -1 && grid[w / R][w % C] == 1) {
          dfs(w, commutationComponent);
        }
      }
    }

    /**
     * 构建图对应的邻接表
     * @return
     */
    private TreeSet<Integer>[] constructGraph() {
      TreeSet<Integer>[] g = new TreeSet[R * C];
      for (int i = 0; i < g.length; i++) {
        g[i] = new TreeSet<>();
      }
      for (int v = 0; v < g.length; v++) {
        //一维数组转二维
        int x = v / C, y = v % C;
        if (grid[x][y] == 1) {
          for (int d = 0; d < dirs.length; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && grid[nextX][nextY] == 1) {
              //二维数组转一维
              int e = nextX * C + nextY;
              g[v].add(e);
              //无向图
              g[e].add(v);
            }
          }
        }
      }
      return g;
    }

    /**
     * 判断下标是否在矩阵内
     * @param nextX
     * @param nextY
     * @return
     */
    private boolean inArea(int nextX, int nextY) {
      return nextX >= 0 && nextX < R && nextY >= 0 && nextY < C;
    }
  }
}