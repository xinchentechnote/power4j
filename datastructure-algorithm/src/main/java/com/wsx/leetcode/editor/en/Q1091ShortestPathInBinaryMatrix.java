package com.wsx.leetcode.editor.en;

//In an N by N square grid, each cell is either empty (0) or blocked (1). 
//
// A clear path from top-left to bottom-right has length k if and only if it is 
//composed of cells C_1, C_2, ..., C_k such that: 
//
// 
// Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are d
//ifferent and share an edge or corner) 
// C_1 is at location (0, 0) (ie. has value grid[0][0]) 
// C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1]) 
// If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0). 
//
// 
//
// Return the length of the shortest such clear path from top-left to bottom-rig
//ht. If such a path does not exist, return -1. 
//
// 
//
// Example 1: 
//
// 
//Input: [[0,1],[1,0]]
//
//
//Output: 2
//
// 
//
// 
// Example 2: 
//
// 
//Input: [[0,0,0],[1,1,0],[1,1,0]]
//
//
//Output: 4
//
// 
//
// 
// 
//
// Note: 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[r][c] is 0 or 1 
// 
// Related Topics Breadth-first Search 
// 👍 426 👎 43


import java.util.LinkedList;
import java.util.Queue;

//Java：Shortest Path in Binary Matrix
public class Q1091ShortestPathInBinaryMatrix {

  public static void main(String[] args) {
    Solution solution = new Solution();
    // TO TEST
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

      //八连通
    private int[][] dirs = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1},
        {-1, 1}, {0, 1}, {1, 1}, {1, 0}};

    private int R;
    private int C;

    public int shortestPathBinaryMatrix(int[][] grid) {
      if (grid[0][0] == 1) {
        return -1;
      }

      R = grid.length;
      C = grid[0].length;
      if (R == 1 && C == 1) {
        return 1;
      }
      //BFS
      // 访问标记数组
      boolean[][] visited = new boolean[R][C];
      //距离数组
      int[][] dis = new int[R][C];
      Queue<Integer> queue = new LinkedList<>();
      queue.add(0);
      visited[0][0] = true;
      dis[0][0] = 1;
      while (!queue.isEmpty()) {
        Integer cur = queue.remove();
        int curX = cur / C, curY = cur % C;
        for (int d = 0; d < 8; d++) {
          int nextX = curX + dirs[d][0];
          int nextY = curY + dirs[d][1];
          if (inArea(nextX, nextY)
              && !visited[nextX][nextY]
              && grid[nextX][nextY] == 0) {
            queue.add(nextX * C + nextY);
            visited[nextX][nextY] = true;
            dis[nextX][nextY] = dis[curX][curY] + 1;
            if (nextX == R - 1 && nextY == C - 1) {
              return dis[nextX][nextY];
            }
          }
        }
      }
      return -1;
    }

    private boolean inArea(int nextX, int nextY) {
      return nextX >= 0 && nextX < R && nextY >= 0 && nextY < C;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}