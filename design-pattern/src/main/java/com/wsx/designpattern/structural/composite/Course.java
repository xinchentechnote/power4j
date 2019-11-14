package com.wsx.designpattern.structural.composite;

import lombok.Data;
import lombok.ToString;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 19:50.
 * @Modified By:
 */
@Data
@ToString
public class Course extends CatalogComponent {
    private String name;
    private double price;

    public Course() {
    }

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
