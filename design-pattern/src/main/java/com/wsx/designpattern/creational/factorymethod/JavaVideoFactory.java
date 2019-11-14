package com.wsx.designpattern.creational.factorymethod;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 0:28.
 * @Modified By:
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
