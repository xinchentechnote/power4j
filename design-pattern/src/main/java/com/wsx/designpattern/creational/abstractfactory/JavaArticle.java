package com.wsx.designpattern.creational.abstractfactory;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 0:54.
 * @Modified By:
 */
public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("java article");
    }
}
