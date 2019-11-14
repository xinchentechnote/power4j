package com.wsx.designpattern.structural.proxy.dynamicproxy;

import com.wusx.innerpower.designpattern.structural.proxy.IOrderService;
import com.wusx.innerpower.designpattern.structural.proxy.Order;
import com.wusx.innerpower.designpattern.structural.proxy.OrderServiceImpl;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 19:40.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);
        order.setOrderInfo("iphone");
        Object bind = new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        IOrderService orderService = (IOrderService) bind;
        orderService.save(order);
    }
}
