package com.wsx.designpattern.creational.singleton;

/**.
 * @Description 懒汉式双重检查
 * 存在隐患：
 *      实例化可能还没完成.
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 13:44.
 * @Modified By:
 */
public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton instance = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (null == instance) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (null == instance) {
                    /**
                     *  1、分配对象内存
                     *  2、初始化对象
                     *  3、设置instance指向第1步分配的内存地址
                     *      2和3可以指令重排序，导致可以访问到不完整的实例
                     *      解决方案：
                     *          1、不允许指令重排序：加volatile关键字
                     *          2、不允许看见指令重排序：静态内部类实现
                     */
                    instance = new LazyDoubleCheckSingleton();

                }
            }
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
