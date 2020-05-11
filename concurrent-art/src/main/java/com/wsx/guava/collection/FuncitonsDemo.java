package com.wsx.guava.collection;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import java.util.function.Predicate;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 18:05 2020/5/9.
 * @Modified By:
 */
public class FuncitonsDemo {

  public static void main(String[] args) {
    Multiset<String> multiset = HashMultiset.create();
    multiset.add("1");
    multiset.add("2");
    multiset.add("3");
    multiset.add("4");
    multiset.add("5");
    multiset.add("world");

    System.out.println(multiset);
    Collections2.transform(multiset,e->{
      return !"5".equals(e);
    });
    System.out.println(multiset);
  }
}
