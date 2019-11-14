### 适配器模式

定义：
    将一个类的接口转换成客户期望的另一个接口
    使原本接口不兼容的类可以在一起工作
使用场景：
    已存在的类，它的方法和需求不匹配时（方法结果相同或者相似）
    不是软件设计阶段考虑的设计模式，是随着软件维护，由于不同产品、不同厂家造成功能类似而接口不同情况下的解决方案

优点：
    能提高类的透明性和复用，现有的类复用但不需要改变
    目标类和适配器类解耦，提高程序拓展性
    符合开闭原则

缺点：
    编写过程需要全面考虑，可能会增加系统的复杂性
    增加系统代码的可读难度

拓展
    类适配器
    对象适配器
    
源码：
    jdk：XmlAdapter
    spring：AdvisorAdapter、MethodBeforeAdviceAdapter
    spring-mvc：HandlerAdapter
    spring-data-jpa：JpaVendorAdapter