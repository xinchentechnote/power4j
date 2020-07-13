package com.wsx.play.datastructure.hash;

import java.util.TreeMap;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 23:45 2020/7/12.
 * @Modified By:
 */
public class HashTable<K extends Comparable<K>, V> {

  private static final int upperTol = 10;
  private static final int lowerTol = 2;
  private static final int initCapacity = 7;

  private TreeMap<K, V>[] hashtable;
  private int M;
  private int size;

  public HashTable() {
    this(initCapacity);
  }

  public HashTable(int M) {
    this.M = M;
    this.size = 0;
    this.hashtable = new TreeMap[M];
    for (int i = 0; i < M; i++) {
      this.hashtable[i] = new TreeMap<>();
    }
  }

  private int hash(K key) {
    return key.hashCode() & 0x7fffffff % M;
  }

  private void resize(int newM) {
    TreeMap<K, V>[] newHashtable = new TreeMap[newM];
    for (int i = 0; i < newM; i++) {
      newHashtable[i] = new TreeMap<>();
    }

    this.M = newM;
    for (int i = 0; i < hashtable.length; i++) {
      TreeMap<K, V> treeMap = hashtable[i];
      for (K key : treeMap.keySet()) {
        newHashtable[hash(key)].put(key, treeMap.get(key));
      }
    }

  }

  public int getSize() {
    return this.size;
  }

  public void add(K key, V value) {
    TreeMap<K, V> map = hashtable[hash(key)];
    if (map.containsKey(key)) {
      map.put(key, value);
    } else {
      map.put(key, value);
      size++;
      if (size >= upperTol * M) {
        resize(2 * M);
      }
    }
  }

  public V remove(K key) {
    TreeMap<K, V> map = hashtable[hash(key)];
    V ret = null;
    if (map.containsKey(key)) {
      ret = map.remove(key);
      size--;
      if (size < lowerTol * M && (M / 2) >= initCapacity) {
        resize(M / 2);
      }
    }
    return ret;
  }

  public void set(K key, V value) {
    TreeMap<K, V> map = hashtable[hash(key)];
    if (map.containsKey(key)) {
      map.put(key, value);
    } else {
      throw new IllegalArgumentException("key is not exist.");
    }
  }

  public boolean contains(K key) {
    return hashtable[hash(key)].containsKey(key);
  }

  public V get(K key) {
    TreeMap<K, V> map = hashtable[hash(key)];
    V ret = null;
    if (map.containsKey(key)) {
      ret = map.get(key);
    }
    return ret;
  }

}
