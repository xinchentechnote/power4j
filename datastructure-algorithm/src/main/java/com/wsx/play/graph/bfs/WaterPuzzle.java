package com.wsx.play.graph.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 有两个水桶，一个装5升，一个装3升，怎么利用这两个水桶，得到4升水.
 * 农夫和狼、羊、菜
 * @Author:ShangxiuWu
 * @Date: 23:00 2020/7/27.
 * @Modified By:
 */
public class WaterPuzzle {

  //最短路径，状态记录
  private int[] pres;
  private int end = -1;

  public WaterPuzzle() {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[100];
    pres = new int[100];
    queue.add(0);
    visited[0] = true;
    while (!queue.isEmpty()) {
      Integer cur = queue.remove();
      int a = cur / 10;
      int b = cur % 10;
      List<Integer> nexts = new ArrayList<>();
      //状态转化

      nexts.add(5 * 10 + b);
      nexts.add(a * 10 + 3);

      nexts.add(0 * 10 + b);
      nexts.add(a * 10 + 0);

      int a2b = Math.min(a, 3 - b);
      nexts.add((a - a2b) * 10 + (b + a2b));
      int b2a = Math.min(b, 5 - a);
      nexts.add((a + b2a) * 10 + (b - b2a));

      //状态转化
      for (int next : nexts) {
        if (!visited[next]) {
          queue.add(next);
          visited[next] = true;
          pres[next] = cur;
          if (next / 10 == 4 || next % 10 == 4) {
            end = next;
            return;
          }
        }
      }
    }
  }

  public Iterable<Integer> result() {
    List<Integer> res = new ArrayList<>();
    if (end != -1) {
      int cur = end;
      while (cur != 0) {
        res.add(cur);
        cur = pres[cur];
      }
      res.add(0);
      Collections.reverse(res);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(new WaterPuzzle().result());
  }
}
