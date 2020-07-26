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

import java.util.TreeSet;

/**
 * 二维数组转以为数组
 * 求图的最大的联通分量
 * 四联通
 * [[-1,0],[0,1]
 * [1,0],[0,-1]]
 * 八联通
 */
public class Q695MaxAreaOfIsland {

  public static void main(String[] args) {
    Solution solution = new Solution();
    // TO TEST
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private int R;
    private int C;
    private int[][] grid;
    private TreeSet<Integer>[] graph;
    private int[][] dirs = {{-1, 0}, {0, 1},
        {1, 0}, {0, -1}};

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
      this.grid = grid;
      this.graph = constructGraph();
      int result = 0;

      return result;
    }

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
                graph[v].add(e);
                //无向图
                graph[e].add(v);
            }
          }
        }
      }
      return g;
    }

    private boolean inArea(int nextX, int nextY) {
      return nextX >= 0 && nextX < R && nextY >= 0 && nextY < C;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}