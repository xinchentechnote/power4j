### 装饰者模式
定义：
    在不改变原有对象的基础上，将功能附加到对象上
    提供了比继承更加弹性的替代方案（拓展原有对象的功能）

使用场景：
    拓展一个类的功能或者给一个类添加附加职责
    动态的给一个对象添加功能，这些功能还可以动态撤销
    
优点：
    继承的有力补充，比继承灵活，不改变原有对象的情况下给一个对象拓展功能
    通过使用不同的装饰类以及这些类的排列组合，可以实现不同的效果
    符合开闭原则

缺点：
    会出现更多的代码，更多的类，增加程序复杂性
    动态装饰时，多层装饰会更复杂

源码：
    jdk：IO类（BufferedReader、BufferedInputStream、FileImageInputStream、FilterInputStream）
    spring：TransactionAwareCacheDecorator
    servlet：SessionRepositoryRequestWrapper、HttpServletRequestWrapper
    mybatis：Cache、FifoCache