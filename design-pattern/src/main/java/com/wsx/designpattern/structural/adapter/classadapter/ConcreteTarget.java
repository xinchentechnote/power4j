package com.wsx.designpattern.structural.adapter.classadapter;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 10:11.
 * @Modified By:
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("具体目标类");
    }
}
