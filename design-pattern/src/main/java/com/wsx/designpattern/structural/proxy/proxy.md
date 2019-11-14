定义：
    为其他对象提供一种代理，以控制对这个对象的访问
    代理对象在应用层和目标对象之间起到中介的作用

使用场景：
    保护目标对象
    增强目标对象
    
优点：代理模式能将代理对象与真实被调用目标对象分离
      一定程度上降低了系统的耦合度，拓展性好
      保护目标对象
      增强目标对象

缺点：
    导致系统设计中类的数量增加
    在客户端和目标对象增加了一个代理对象，会造成请求处理速度变慢
    增加系统的复杂度


静态代理
动态代理：
    jdk动态代理生成一个新类（继承接口的时候，使用jdk动态代理）
    Cglib使用继承，生成子类
    spring core动态代理实现
    CGlib，使用asm，比JDK动态代理慢
源码：
    jdk：Proxy
    spring:ProxyFactoryBean、JdkDynamicAopProxy、CglibAopProxy
    mybatis:MapperRegistry、MapperProxy
    