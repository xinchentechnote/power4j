package com.wsx.designpattern.structural.flyweight;

import lombok.Data;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 12:00.
 * @Modified By:
 */
@Data
public class Manager implements Employee {

    private String department;
    private String title;
    private String reportContent;

    @Override
    public void report() {
        System.out.println(reportContent);
    }
}
