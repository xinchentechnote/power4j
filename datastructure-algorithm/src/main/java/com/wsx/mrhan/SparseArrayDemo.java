package com.wsx.mrhan;

import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * .
 * @Description
 * @Author:ShangxiuWu
 * @Date: 16:55 2020/5/8.
 * @Modified By:
 */
public class SparseArrayDemo {

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  static class Node {

    private int row;
    private int col;
    private int value;

    @Override
    public String toString() {
      return row +
          " " + col +
          " " + value + "\n";
    }
  }

  public static void main(String[] args) {
    //测试数据
    Integer[][] sourcesArr = new Integer[10][10];
    sourcesArr[3][4] = 2;
    sourcesArr[5][9] = 5;
    sourcesArr[6][6] = 6;
    printArr(sourcesArr);
    //转化为稀疏数组
    List<Node> nodes = new ArrayList<>();
    for (int i = 0; i < sourcesArr.length; i++) {
      Integer[] ints = sourcesArr[i];
      for (int j = 0; j < ints.length; j++) {
        Integer value = sourcesArr[i][j];
        if (value != null) {
          Node node = new Node(i, j, value);
          nodes.add(node);
        }
      }
    }
    System.out.println(nodes);

  }

  private static void printArr(Integer[][] sourcesArr) {
    if (sourcesArr == null) {
      return;
    }
    for (int i = 0; i < sourcesArr.length; i++) {
      Integer[] ints = sourcesArr[i];
      Joiner on = Joiner.on(" ").useForNull("0");
      System.out.println(on.join(ints));
    }
  }


}
