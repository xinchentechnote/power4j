package com.wsx.guava.string;

import com.google.common.base.Splitter;

public class SplitterDemo {

  public static void main(String[] args) {
    String data = "1,2,3,4,,7";
    Splitter on = Splitter.on(",")
        .omitEmptyStrings()
        .trimResults();
    Iterable<String> split = on.split(data);
    System.out.println(split);//[1, 2, 3, 4, 7]
  }
}
