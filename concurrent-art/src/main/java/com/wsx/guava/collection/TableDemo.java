package com.wsx.guava.collection;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableDemo {

  public static void main(String[] args) {
    Table<String,String,String> table = HashBasedTable.create();

    table.put("user","wusx","hello");
    table.put("user","ap","world");
    table.put("user","ap","1");

    System.out.println(table);

  }
}
