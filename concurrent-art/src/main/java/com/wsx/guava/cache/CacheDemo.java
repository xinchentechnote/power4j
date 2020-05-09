package com.wsx.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 16:37 2020/5/9.
 * @Modified By:
 */
public class CacheDemo {

  public static void main(String[] args) {

    LoadingCache<String, String> graphs1 = CacheBuilder.newBuilder()
        .maximumSize(1000)
        .build(
            new CacheLoader<String, String>() {

              @Override
              public String load(String key) throws Exception {
                return "hello " + key;
              }
            });

    Cache<String, String> cache = CacheBuilder.newBuilder()
        .maximumSize(1000)
        .build(); // look Ma, no CacheLoader
  }

}
