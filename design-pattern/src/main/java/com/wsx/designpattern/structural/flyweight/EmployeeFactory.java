package com.wsx.designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 12:01.
 * @Modified By:
 */
public class EmployeeFactory {
    private static final Map<String, Employee> EMPLOYEE_MAP = new HashMap<>();

    public static Employee getManager(String department) {
        Employee employee = EMPLOYEE_MAP.get(department);
        if (null == employee) {
            employee = new Manager();
            Manager manager = Manager.class.cast(employee);
            manager.setTitle("经理");
            manager.setDepartment(department);
            manager.setReportContent(department+"做报告");
            EMPLOYEE_MAP.put(department, manager);
            System.out.println("创建部门经理");
        }
        return employee;
    }
}
