package com.wsx.guava.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class MultimapDemo {

  public static void main(String[] args) {

    Multimap<String, Integer> multimap =
        ArrayListMultimap.create();//{sutpc=[1, 2], hello=[2]}
    //HashMultimap.create();//{sutpc=[1, 1, 2], hello=[2]}

    multimap.put("sutpc", 1);
    multimap.put("sutpc", 1);
    multimap.put("sutpc", 2);
    multimap.put("hello", 2);
    System.out.println(multimap);

  }
}
