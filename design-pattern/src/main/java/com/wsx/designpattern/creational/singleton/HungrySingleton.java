package com.wsx.designpattern.creational.singleton;

/**.
 * @Description 最简单的，在简单的单例模式中可以使用.
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 14:04.
 * @Modified By:
 */
public class HungrySingleton {
    private final static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        //防止放射攻击
        if (null != instance) {
            throw new RuntimeException("单例对象，禁止反射调用！");
        }
    }

    public static HungrySingleton getInstance() {
        return instance;
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
        return instance;
    }

}
