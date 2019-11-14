package com.wsx.designpattern.creational.abstractfactory;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 0:57.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();
    }
}
