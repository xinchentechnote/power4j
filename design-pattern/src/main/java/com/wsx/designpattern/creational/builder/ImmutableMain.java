package com.wsx.designpattern.creational.builder;

import com.google.common.collect.ImmutableSet;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 22:36.
 * @Modified By:
 */
public class ImmutableMain {
    public static void main(String[] args) {
        ImmutableSet<String> set = ImmutableSet.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();
        System.out.println(set);
    }
}
