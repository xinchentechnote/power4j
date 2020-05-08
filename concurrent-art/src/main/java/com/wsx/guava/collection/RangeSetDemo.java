package com.wsx.guava.collection;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class RangeSetDemo {

  public static void main(String[] args) {
    RangeSet<String> rangeSet = TreeRangeSet.create();
    rangeSet.add(Range.closed("a", "c"));
    boolean contains = rangeSet.contains("b");
    System.out.println(contains);
  }
}
