package com.wsx.designpattern.creational.singleton;

/**.
 * @Description 静态内部类
 *      利用Class对象的初始化锁，保证只有一个线程能初始化类，内部的指令重排序对其他线程不可见.
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 13:59.
 * @Modified By:
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
        //防止放射攻击
        if (null != InnerClass.instance) {
            throw new RuntimeException("单例对象，禁止反射调用！");
        }
    }

    private static class InnerClass {
        private static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.instance;
    }

    /**
     *@Description 防止序列化安全问题，保护单例模式不被破坏.
     *@params
     *@return
     *@Author wusx
     *@Date 14:11 2019/11/2
     *@Modified
     */
    private Object readResolve() {
        return InnerClass.instance;
    }
}
