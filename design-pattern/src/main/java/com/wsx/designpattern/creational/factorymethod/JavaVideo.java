package com.wsx.designpattern.creational.factorymethod;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 23:09.
 * @Modified By:
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制java课程");
    }
}
