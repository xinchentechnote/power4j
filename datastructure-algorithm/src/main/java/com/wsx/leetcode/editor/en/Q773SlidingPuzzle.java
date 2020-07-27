package com.wsx.leetcode.editor.en;

//On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and
// an empty square represented by 0. 
//
// A move consists of choosing 0 and a 4-directionally adjacent number and swapp
//ing it. 
//
// The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]
//]. 
//
// Given a puzzle board, return the least number of moves required so that the s
//tate of the board is solved. If it is impossible for the state of the board to b
//e solved, return -1. 
//
// Examples: 
//
// 
//Input: board = [[1,2,3],[4,0,5]]
//Output: 1
//Explanation: Swap the 0 and the 5 in one move.
// 
//
// 
//Input: board = [[1,2,3],[5,4,0]]
//Output: -1
//Explanation: No number of moves will make the board solved.
// 
//
// 
//Input: board = [[4,1,2],[5,0,3]]
//Output: 5
//Explanation: 5 is the smallest number of moves that solves the board.
//An example path:
//After move 0: [[4,1,2],[5,0,3]]
//After move 1: [[4,1,2],[0,5,3]]
//After move 2: [[0,1,2],[4,5,3]]
//After move 3: [[1,0,2],[4,5,3]]
//After move 4: [[1,2,0],[4,5,3]]
//After move 5: [[1,2,3],[4,5,0]]
// 
//
// 
//Input: board = [[3,2,4],[1,5,0]]
//Output: 14
// 
//
// Note: 
//
// 
// board will be a 2 x 3 array as described above. 
// board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5]. 
// 
// Related Topics Breadth-first Search 
// 👍 693 👎 25


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Java：Sliding Puzzle
public class Q773SlidingPuzzle {

  public static void main(String[] args) {
    Solution solution = new Solution();
    // TO TEST
  }

  static
      //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int slidingPuzzle(int[][] board) {
      Queue<String> queue = new LinkedList<>();
      Map<String, Integer> visited = new HashMap<>();
      String initStatus = boardToString(board);
      if ("123450".equals(initStatus)) {
        return 0;
      }
      queue.add(initStatus);
      visited.put(initStatus, 0);
      while (!queue.isEmpty()) {
        String cur = queue.remove();
        List<String> nextStr = getNextStr(cur);
        for (String next : nextStr) {
          if (!visited.containsKey(next)) {
            queue.add(next);
            visited.put(next, visited.get(cur) + 1);
            if ("123450".equals(next)) {
              return visited.get(next);
            }
          }
        }
      }
      return -1;
    }

    //状态转换，求下一个状态
    private List<String> getNextStr(String cur) {
      List<String> res = new ArrayList<>();
      int[][] board = stringToBoard(cur);
      int zeroIndex;
      for (zeroIndex = 0; zeroIndex < 6; zeroIndex++) {
        if (board[zeroIndex / 3][zeroIndex % 3] == 0) {
          break;
        }
      }
      int zx = zeroIndex / 3;
      int zy = zeroIndex % 3;
      //四联通
      for (int d = 0; d < 4; d++) {
        int nextX = zx + dirs[d][0];
        int nextY = zy + dirs[d][1];
        if (inArea(nextX, nextY)) {
          swap(board, zx, zy, nextX, nextY);
          res.add(boardToString(board));
          swap(board, zx, zy, nextX, nextY);
        }
      }
      return res;
    }

    private void swap(int[][] board, int zx, int zy, int nextX, int nextY) {
      int tmp = board[zx][zy];
      board[zx][zy] = board[nextX][nextY];
      board[nextX][nextY] = tmp;
    }

    private boolean inArea(int x, int y) {
      return x >= 0 && x < 2 && y >= 0 && y < 3;
    }

    private String boardToString(int[][] board) {
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          builder.append(board[i][j]);
        }
      }
      return builder.toString();
    }

    private int[][] stringToBoard(String s) {
      int[][] board = new int[2][3];
      for (int i = 0; i < 6; i++) {
        board[i / 3][i % 3] = s.charAt(i) - '0';
      }
      return board;
    }

  }
//leetcode submit region end(Prohibit modification and deletion)

}