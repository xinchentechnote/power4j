package com.wsx.designpattern.behavioral.iterator;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 21:42.
 * @Modified By:
 */
public interface CourseIterator {
    Course nextCourse();

    boolean isLastCourse();
}
