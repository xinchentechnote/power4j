package com.wsx.designpattern.structural.adapter.objectadapter;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 10:12.
 * @Modified By:
 */
public class Adapter implements Target {

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
