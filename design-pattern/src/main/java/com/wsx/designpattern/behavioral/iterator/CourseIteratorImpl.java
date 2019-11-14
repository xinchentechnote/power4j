package com.wsx.designpattern.behavioral.iterator;

import java.util.List;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 21:45.
 * @Modified By:
 */
public class CourseIteratorImpl implements CourseIterator {

    private List courseList;
    private int position;
    private Course course;

    public CourseIteratorImpl(List courseList) {
        this.courseList = courseList;
    }

    @Override
    public Course nextCourse() {
        course = ((Course) courseList.get(position));
        position++;
        return course;
    }

    @Override
    public boolean isLastCourse() {
        if (position < this.courseList.size()) {
            return false;
        }
        return true;
    }
}
