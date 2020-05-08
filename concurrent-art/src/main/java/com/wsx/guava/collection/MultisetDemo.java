package com.wsx.guava.collection;

import com.google.common.collect.BoundType;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;
import java.util.Set;

public class MultisetDemo {

  public static void main(String[] args) {

    Multiset<String> multiset = HashMultiset.create();
    multiset.add("hello");
    multiset.add("hello");
    multiset.add("world");
    multiset.add("sutpc");
    System.out.println(multiset.count("hello"));//2
    Set<String> strings = multiset.elementSet();
    System.out.println(strings);//[world, hello, sutpc]
    Set<Entry<String>> entries = multiset.entrySet();
    System.out.println(entries);//[world, hello x 2, sutpc]

    SortedMultiset<String> sortedMultiset = TreeMultiset.create();
    sortedMultiset.add("2");
    sortedMultiset.add("3");
    sortedMultiset.add("3");
    sortedMultiset.add("3");
    sortedMultiset.add("1");
    sortedMultiset.add("4");
    sortedMultiset.add("5");
    sortedMultiset.add("6");
    SortedMultiset subMultiset = sortedMultiset
        .subMultiset("1", BoundType.CLOSED, "5", BoundType.CLOSED);
    System.out.println(subMultiset.size());//7
    Set set = subMultiset.entrySet();
    System.out.println(set);//[1, 2, 3 x 3, 4, 5]
  }

}
