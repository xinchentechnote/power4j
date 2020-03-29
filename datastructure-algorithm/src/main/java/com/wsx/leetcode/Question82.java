package com.wsx.leetcode;

/**
 * @Description 82. Remove Duplicates from Sorted List II
 * @Author:ShangxiuWu
 * @Date: 20:29 2020/3/28.
 * @Modified By:
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Question82 {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode temp = new ListNode(0);
    while (head != null && head.next != null) {
      if (head.val == head.next.val) {
        head.next = head.next.next;
      } else {
        head = head.next;
      }
    }
    return temp.next;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
