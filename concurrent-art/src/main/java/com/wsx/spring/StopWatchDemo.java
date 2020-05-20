package com.wsx.spring;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 9:56 2020/5/14.
 * @Modified By:
 */
public class StopWatchDemo {

  public static void main(String[] args) throws InterruptedException {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    for (int i=0;i<1000;i++){
      Thread.sleep(10);//模拟耗时操作
    }
    stopWatch.stop();
    System.out.println(stopWatch.getTime());//11113ms
  }
}
