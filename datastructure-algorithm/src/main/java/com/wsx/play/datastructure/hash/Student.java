package com.wsx.play.datastructure.hash;

/**
 * @Description 重写hashcode和equals.
 * @Author:ShangxiuWu
 * @Date: 23:34 2020/7/12.
 * @Modified By:
 */
public class Student {

  private int grade;
  private int clazz;
  private String name;

  @Override
  public int hashCode() {
    int b = 31;
    int hash = 0;
    hash = hash * b + grade;
    hash = hash * b + clazz;
    hash = hash * b + name.toLowerCase().hashCode();
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (null == obj) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Student student = (Student) obj;

    return this.grade == student.grade
        && this.clazz == student.clazz
        && this.name.toLowerCase().equals(student.name.toLowerCase());
  }
}
