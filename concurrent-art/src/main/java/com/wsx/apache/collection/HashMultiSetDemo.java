package com.wsx.apache.collection;

import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 17:40 2020/5/13.
 * @Modified By:
 */
public class HashMultiSetDemo {

  public static void main(String[] args) {
    MultiSet set = new HashMultiSet();
    set.add("suptc");
    set.add("suptc");
    set.add("wusx");
    System.out.println(set);//[wusx:1, suptc:2]
    int count = set.getCount("suptc");
    System.out.println(count);//2
    Set uniqueSet = set.uniqueSet();
    System.out.println(uniqueSet);//[wusx, suptc]
  }
}
