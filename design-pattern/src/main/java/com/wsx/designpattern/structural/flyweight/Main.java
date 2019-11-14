package com.wsx.designpattern.structural.flyweight;

import java.util.Random;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 12:07.
 * @Modified By:
 */
public class Main {
    private static final String[] departments = {"RD", "QA", "PM"};

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            String department = departments[random.nextInt(3)];
            Employee manager = EmployeeFactory.getManager(department);
            manager.report();
        }

        System.out.println(new Integer(10) == new Integer(10));
        System.out.println(Integer.valueOf(10) == new Integer(10));
        System.out.println(Integer.valueOf(10) == Integer.valueOf(10));
        System.out.println(new Integer(1000) == new Integer(1000));

        Integer a = 10;
        Integer b = 10;
        System.out.println(a == b);

        Integer c = 1000;
        Integer d = 1000;
        System.out.println(c == d);
        System.out.println(c.equals(d));

    }
}
