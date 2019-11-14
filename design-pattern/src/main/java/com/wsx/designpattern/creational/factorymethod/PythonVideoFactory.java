package com.wsx.designpattern.creational.factorymethod;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 0:27.
 * @Modified By:
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
