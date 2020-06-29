package com.wsx.leetcode;

import java.util.Arrays;
import java.util.Date;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

/**
 * @Description 283. Move Zeroes.
 * @Author:ShangxiuWu
 * @Date: 下午7:58 2020/6/29.
 * @Modified By:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class Question283 {

  public static void main(String[] args) {
    int[] data = new int[]{0, 1, 0, 3, 12};
    new Question283().moveZeroes(data);
    System.out.println(Arrays.toString(data));
  }

  public void moveZeroes(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j++] = nums[i];
      }
    }
    for (int i = j; i < nums.length; i++) {
      nums[i] = 0;
    }
  }
}
