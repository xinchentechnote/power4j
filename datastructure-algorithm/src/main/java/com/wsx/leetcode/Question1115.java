package com.wsx.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:22 2020/6/21.
 * @Modified By:
 */
public class Question1115 {

  public static void main(String[] args) {

  }

  class FooBar {

    private int n;


    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private volatile boolean printFooFlag = true;

    public FooBar(int n) {
      this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

      for (int i = 0; i < n; i++) {
        lock.lock();
        try {
          if (!printFooFlag) {
            fooCondition.await();
          }
          printFoo.run();
          printFooFlag = false;
          barCondition.signal();
        } finally {
          lock.unlock();
        }
      }
    }

    public void bar(Runnable printBar) throws InterruptedException {

      for (int i = 0; i < n; i++) {
        lock.lock();
        try {
          if (printFooFlag) {
            barCondition.await();
          }
          printBar.run();
          printFooFlag = true;
          fooCondition.signal();
        } finally {
          lock.unlock();
        }
      }
    }
  }
}
