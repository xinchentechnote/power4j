package com.wsx.designpattern.creational.simplefactory;

/**.
 * @Description 定义：由一个工厂对象决定创建出哪一种产品类的实例
 * 创建型、不属于GOF23种设计模式
 * 使用场景：
 *      工厂类负责创建的对象比较少
 *      应用层只知道传入工厂类的参数，对于如何创建对象（逻辑）不关心.
 *  优点：
 *      只需要一个参数就可以获得对于的对象、不关心创建细节
 *  缺点：
 *      工厂类的职责相对过重、增加新的产品，需要修改工厂类判断逻辑，违背开闭原则
 *  源码：
 *      jdk：Calendar
 *      spring：
 *      mybatis：
 *      log：LoggerFactory（简单工厂、工厂方法）、LoggerContext
 *
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 22:56.
 * @Modified By:
 */
public class SimpleFactory {
}
