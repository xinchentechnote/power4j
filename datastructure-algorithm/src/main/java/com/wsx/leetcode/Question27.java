package com.wsx.leetcode;

/**
 * @Description 27.Remove Element.
 * @Author:ShangxiuWu
 * @Date: 下午7:52 2020/6/29.
 * @Modified By:
 */
public class Question27 {


  public static void main(String[] args) {
    //Given nums = [0,1,2,2,3,0,4,2], val = 2
    int[] data = new int[]{0,1,2,2,3,0,4,2};
    System.out.println(new Question27().removeElement(data,2));
  }

  public int removeElement(int[] nums, int val) {
    int result=0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i]!=val){
        nums[result++]=nums[i];
      }
    }
    return result;
  }

}
