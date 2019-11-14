package com.wsx.designpattern.creational.builder;

/**.
 * @Description 建造者模式，属于创建型.
 * 将一个复杂的对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 * 用户只需要指定创造的类型就可以得到它们，建造过程及细节不需要知道
 * 适用场景：
 *      一个对象有非常复杂的内部结构（很多属性）
 *      想把复杂对象的创建和使用分离
 * 优点：
 *      封装性好，创建和使用分离
 *      拓展性好、建造类之间独立、一定程度上解耦
 * 缺点：
 *      产生多余的Builder对象
 *      产品内部分生变化，建造者都要修改，成本比较大
 *
 *  源码：
 *      jdk: StringBuilder、StringBuffer
 *      guava：ImmutableSet、cache
 *      spring：BeanDefinitionBuilder
 *      mybatis: SqlSessionFactoryBuilder、XMLConfigBuilder
 *
 * @Author:ShangxiuWu
 * @Date: 19:39 2019/9/28.
 * @Modified By:
 */
public class Builder {
}
