package com.wsx.designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 21:43.
 * @Modified By:
 */
public class CourseAggregateImpl implements CourseAggregate {

    private List courseList;

    public CourseAggregateImpl() {
        this.courseList = new ArrayList();
    }

    @Override
    public void add(Course course) {
        this.courseList.add(course);
    }

    @Override
    public void removeCourse(Course course) {
        this.courseList.remove(course);
    }

    @Override
    public CourseIterator getCourseIterator() {
        return new CourseIteratorImpl(this.courseList);
    }
}
