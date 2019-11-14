package com.wsx.designpattern.behavioral.iterator;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 21:49.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("1");
        Course course2 = new Course("2");
        Course course3 = new Course("3");
        Course course4 = new Course("4");

        CourseAggregate courseAggregate = new CourseAggregateImpl();
        courseAggregate.add(course1);
        courseAggregate.add(course2);
        courseAggregate.add(course3);

        courseAggregate.removeCourse(course4);


        CourseIterator courseIterator = courseAggregate.getCourseIterator();
        while (!courseIterator.isLastCourse()) {
            Course course = courseIterator.nextCourse();
            System.out.println(course);
        }
    }
}
