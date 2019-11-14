package com.wsx.designpattern.structural.decorator;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:40.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        AbstractBatterCake batterCake = new BatterCake();
        batterCake = new EggDecorator(batterCake);
        batterCake = new SausageDecorator(batterCake);
        batterCake = new SausageDecorator(batterCake);
        System.out.println(batterCake);
    }
}
