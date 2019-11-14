package com.wsx.designpattern.creational.builder.v1;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 22:16.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        CourceBuilder courceBuilder = new CourseActualBuilder();
        Coach coach = new Coach(courceBuilder);
        Cource cource = coach.makeCource("java", "ppt", "video", "article", "QA");
        System.out.println(cource);
    }
}
