package com.wsx.leetcode;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 下午5:25 2020/6/29.
 * @Modified By:
 */
public class Question203 {


  public static void main(String[] args) {
    int[] data = new int[]{2, 3, 4, 5, 7, 8, 3, 9, 3};
    ListNode listNode = new ListNode(data);
    System.out.println(listNode);
    Question203 question203 = new Question203();
    System.out.println(question203.removeElements2(listNode, 3, 0));
  }

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode pre = dummyHead;
    while (null != pre.next) {
      if (pre.next.val == val) {
        pre.next = pre.next.next;
      } else {
        pre = pre.next;
      }
    }
    return dummyHead.next;
  }

  //递归解法
  public ListNode removeElements1(ListNode head, int val) {
    if (null == head) {
      return null;
    }
    ListNode listNode = removeElements1(head.next, val);
    if (head.val == val) {
      return listNode;
    } else {
      head.next = listNode;
      return head;
    }
    //head.next = removeElements1(head.next, val);
    //return head.val == val ? head.next : head;
  }

  //递归解法,打印调试信息
  public ListNode removeElements2(ListNode head, int val, int depth) {
    String depthString = depthString(depth);
    System.out.print(depthString);
    System.out.println("remove " + val + " in " + head);
    if (null == head) {
      return null;
    }
    ListNode listNode = removeElements2(head.next, val, depth + 1);
    System.out.print(depthString);
    System.out.println("after remove " + val + " : " + listNode);
    ListNode result;
    if (head.val == val) {
      result = listNode;
    } else {
      head.next = listNode;
      result = head;
    }
    System.out.print(depthString);
    System.out.println("Return :" + result);
    return result;
  }

  public String depthString(int depth) {
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < depth; i++) {
      buffer.append("--");
    }
    return buffer.toString();
  }


  static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int[] arr) {
      if (null == arr || arr.length == 0) {
        throw new IllegalArgumentException("arr cannot be null.");
      }
      this.val = arr[0];
      ListNode pre = this;
      for (int i = 1; i < arr.length; i++) {
        pre.next = new ListNode(arr[i]);
        pre = pre.next;
      }
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {

      StringBuilder builder = new StringBuilder();
      ListNode cur = this;
      while (cur != null) {
        builder.append(cur.val);
        builder.append("->");
        cur = cur.next;
      }

      return builder.toString();
    }
  }

}

