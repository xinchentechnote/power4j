package com.wsx.designpattern.creational.prototype.clone;

import java.util.Date;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 1:37.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Pig pig = new Pig();
        pig.setName("peiqi");
        pig.setBirthday(new Date());
        Pig clone = Pig.class.cast(pig.clone());
        System.out.println(pig);
        System.out.println(clone);
        clone.setName("ap001");
        clone.getBirthday().setTime(6666666L);
        System.out.println(pig);
        System.out.println(clone);
    }
}
