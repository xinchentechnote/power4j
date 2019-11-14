package com.wsx.designpattern.creational.singleton;

/**.
 * @Description 懒汉式:存在线程安全问题.
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 13:44.
 * @Modified By:
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     *@Description 防止序列化安全问题，保护单例模式不被破坏.
     *@params
     *@return
     *@Author  wusx
     *@Date 14:11 2019/11/2
     *@Modified
     */
    private Object readResolve() {
        return instance;
    }

}
