package com.wsx.designpattern.creational.simplefactory;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 23:10.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        video.produce();
    }
}
