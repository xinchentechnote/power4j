package com.wsx.designpattern.creational.abstractfactory;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 0:56.
 * @Modified By:
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PyhtonArticle();
    }
}
