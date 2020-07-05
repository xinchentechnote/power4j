package com.wsx.play.datastructure.map;

/**
 * @Description 映射（字典）.
 * @Author:ShangxiuWu
 * @Date: 19:27 2020/7/5.
 * @Modified By:
 */
public interface Map<K, V> {

  void add(K key, V value);

  V remove(K key);

  boolean contains(K key);

  V get(K key);

  void set(K key, V value);

  int getSize();

  boolean isEmpty();

}
