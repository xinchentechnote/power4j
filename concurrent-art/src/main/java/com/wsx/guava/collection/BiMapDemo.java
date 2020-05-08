package com.wsx.guava.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapDemo {

  public static void main(String[] args) {

    BiMap<String, Integer> nameToId = HashBiMap.create();
    nameToId.put("wusx", 1);
    nameToId.put("wushangxiu", 2);
    //nameToId.put("sutpc", 1);
    //nameToId.forcePut("sutpc", 1);
    nameToId.put("sutpc", 3);
    nameToId.put("sutpc", 4);
    System.out.println(nameToId.get("sutpc"));
    System.out.println(nameToId.inverse().get(1));

  }

}
