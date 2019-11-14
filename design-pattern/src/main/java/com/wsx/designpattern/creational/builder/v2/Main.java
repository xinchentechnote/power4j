package com.wsx.designpattern.creational.builder.v2;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 22:27.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        Cource cource = new Cource.CourceBuilder()
                .builderName("java")
                .builderArticle("article")
                .builderPpt("ppt")
                .builderVideo("video")
                .build();
        System.out.println(cource);
    }
}
