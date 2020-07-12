package com.wsx.play.datastructure.hash;

import java.util.TreeMap;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 23:45 2020/7/12.
 * @Modified By:
 */
public class HashTable<K extends Comparable<K>, V> {

  private TreeMap<K, V>[] hashtable;
  private int M;
  private int size;

}
