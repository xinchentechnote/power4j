package com.wsx.designpattern.behavioral.template;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 20:44.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        AbstractCourse java = new JavaCourse();
        java.makeCourse();
        AbstractCourse python = new PythonCourse(true);
        python.makeCourse();
    }
}
