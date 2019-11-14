package com.wsx.designpattern.structural.composite;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 19:56.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        CatalogComponent linux = new Course("linux", 500);
        CatalogComponent windows = new Course("windows", 510);
        CatalogComponent java = new CourseCatalog("java",2);

        CatalogComponent mmall1 = new Course("java一期", 1000);
        CatalogComponent mmall2 = new Course("java一期", 1200);
        CatalogComponent designPattern = new Course("设计模式", 1500);
        java.add(mmall1);
        java.add(mmall2);
        java.add(designPattern);

        CatalogComponent root = new CourseCatalog("root",1);
        root.add(linux);
        root.add(windows);
        root.add(java);
        root.print();

    }
}
