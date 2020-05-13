package com.wsx.apache.collection;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 15:18 2020/5/13.
 * @Modified By:
 */
public class BidiMapDemo {

  public static void main(String[] args) {
    BidiMap ChineseEnglishMap = new DualHashBidiMap();
    ChineseEnglishMap.put("hello", "你好");
    ChineseEnglishMap.put("hello", "你好");
    ChineseEnglishMap.put("hello1", "你好");
    System.out.println(ChineseEnglishMap.get("hello"));
    System.out.println(ChineseEnglishMap.getKey("你好"));
  }
}
