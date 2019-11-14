package com.wsx.designpattern.structural.adapter.objectadapter;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 10:14.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget= new Adapter();
        adapterTarget.request();
    }
}
