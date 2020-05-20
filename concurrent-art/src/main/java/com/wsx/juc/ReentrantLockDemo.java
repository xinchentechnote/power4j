package com.wsx.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 9:33 2020/5/20.
 * @Modified By:
 */
public class ReentrantLockDemo {

  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
//    condition.await();
//    condition.signal();
  }
}
