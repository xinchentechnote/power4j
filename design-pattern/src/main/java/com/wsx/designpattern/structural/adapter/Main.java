package com.wsx.designpattern.structural.adapter;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 10:24.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        DC5 dc5 = new Dc5PowerAdapter();
        System.out.println(dc5.output());
    }
}
