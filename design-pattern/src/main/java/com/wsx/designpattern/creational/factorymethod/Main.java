package com.wsx.designpattern.creational.factorymethod;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 23:10.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();
    }
}
