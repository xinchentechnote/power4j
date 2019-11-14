package com.wsx.designpattern.structural.adapter.classadapter;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 10:12.
 * @Modified By:
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
