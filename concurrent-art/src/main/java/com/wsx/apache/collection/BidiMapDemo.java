package com.wsx.apache.collection;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 15:18 2020/5/13.
 * @Modified By:
 */
public class BidiMapDemo {

  public static void main(String[] args) {
    BidiMap chineseEnglishMap = new DualHashBidiMap();
    chineseEnglishMap.put("hello", "你好");
    chineseEnglishMap.put("hello", "你好");
    chineseEnglishMap.put("hello1", "你好");
    System.out.println(chineseEnglishMap.get("hello"));//null
    System.out.println(chineseEnglishMap.getKey("你好"));//hello1
    System.out.println(chineseEnglishMap.get("hello1"));//你好
    System.out.println(chineseEnglishMap);//{hello1=你好}
  }
}
