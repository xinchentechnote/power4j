package com.wsx.designpattern.structural.proxy.staticproxy;

import com.wusx.innerpower.designpattern.structural.proxy.Order;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 19:21.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);
        order.setOrderInfo("iphone");
        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy();
        proxy.save(order);
    }
}
