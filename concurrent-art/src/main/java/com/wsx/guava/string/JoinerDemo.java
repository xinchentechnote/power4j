package com.wsx.guava.string;

import com.google.common.base.Joiner;

public class JoinerDemo {

  public static void main(String[] args) {
    Joiner joiner = Joiner.on(",").skipNulls();
    String join = joiner.join("1", "2", "3", null);
    System.out.println(join);//1,2,3

  }
}
