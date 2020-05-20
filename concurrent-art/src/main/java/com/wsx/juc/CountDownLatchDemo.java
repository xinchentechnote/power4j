package com.wsx.juc;

import com.google.common.base.Stopwatch;
import java.util.concurrent.CountDownLatch;

/**.
 * @Author:wusx
 * @Date: Created in 15:09 2020/3/11 0011.
 * @Description .
 * @Modified By:
 */
public class CountDownLatchDemo {

  public static void main(String[] args) {
    try {
      Stopwatch stopwatch = Stopwatch.createStarted();
      CountDownLatch countDownLatch = new CountDownLatch(2);
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(2000);
            countDownLatch.countDown();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }).start();

      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(4000);
            countDownLatch.countDown();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }).start();

      countDownLatch.await();
      System.out.println(stopwatch.stop().elapsed());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
