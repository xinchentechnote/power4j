package com.wsx.designpattern.creational.simplefactory;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 23:09.
 * @Modified By:
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制python课程");
    }
}
