package com.wsx.designpattern.creational.singleton;

/**.
 * @Description 线程内单例.
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 14:52.
 * @Modified By:
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {
    }

    private static final ThreadLocal<ThreadLocalSingleton> SINGLETON_THREAD_LOCAL = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance() {
        return SINGLETON_THREAD_LOCAL.get();
    }

}
