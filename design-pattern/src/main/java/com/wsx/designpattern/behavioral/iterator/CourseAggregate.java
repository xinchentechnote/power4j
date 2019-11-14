package com.wsx.designpattern.behavioral.iterator;

/**.
 * @Description Aggregate:总数，合计.
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 21:40.
 * @Modified By:
 */
public interface CourseAggregate {
    void add(Course course);
    void removeCourse(Course course);

    CourseIterator getCourseIterator();
}
