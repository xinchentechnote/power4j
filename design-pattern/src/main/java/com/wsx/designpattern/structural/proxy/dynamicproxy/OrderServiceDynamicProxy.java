package com.wsx.designpattern.structural.proxy.dynamicproxy;

import com.wusx.innerpower.designpattern.structural.proxy.Order;
import com.wusx.innerpower.designpattern.structural.proxy.staticproxy.DataSourceContextHolder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 19:26.
 * @Modified By:
 */
@Slf4j
public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object bind() {
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object argObject = args[0];
        before(argObject);
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    private void before(Object object) {
        Integer userId = 0;
        log.info("动态代理分配到before()");
        if (object instanceof Order) {
            Order order = Order.class.cast(object);
            userId = order.getUserId();
        }
        int router = userId % 2;
        log.info("动态代理分配到【db" + router + "】");
        DataSourceContextHolder.setDbType("db" + router);
    }


    private void after() {
        log.info("动态代理分配到after()");
    }
}
