package com.wsx.designpattern.creational.singleton;

/**.
 * @Description 单例模式：属于创建型.
 * 保证一个类仅有一个实例，并提供一个全局访问点
 * 使用场景：
 *      1、全局计数器
 *      2、线程池、数据库连接池
 * 源码：
 *     JDK:Runtime（饿汉式）、Desktop（容器单例）
 *     Spring:单例（在spring容器中单例）
 *     Mybatis:ErrorContext（基于ThreadLocal的线程单例）
 * 优点：
 *      1、在内存中只有一个实例，减少了内存开销
 *      2、可以避免对资源的多重占用
 *      3、设置了全局访问点，严格控制访问
 * 缺点：
 *      没有接口，拓展困难
 * 重点：
 *      1、私有构造器
 *      2、线程安全
 *      3、延时加载
 *      4、序列化和反序列化安全
 *          防止序列化：
 *              不实现序列化接口
 *              重写readResolve()方法，有创建了实例，但是没有返回，而是返回了原来的实例
 *      5、反射攻击 (ObjectInputStream)
 *          解决方案：
 *              饿汉模式，可以在构造函数中做非空判断，抛出异常
 *              懒汉模式：不可以避免
 *              用枚举实现
 *      6、通过克隆可以破坏单例模式
 *          解决方案：
 *              禁止实现Cloneable接口
 *              在clone方法中调用getInstance方法
 * 实现：
 *      double check
 *      静态内部类
 *      枚举
 * 反编译工具JAD
 *      反编译枚举单例实现类
 *  io相关类：保护序列化安全
 *  反射相关类：保护不受反射攻击
 *
 * @Author:ShangxiuWu
 * @Date: 19:39 2019/9/28.
 * @Modified By:
 */
public class Singleton {
    private Singleton() {
    }
}
