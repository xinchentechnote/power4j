package com.wsx.designpattern.structural.proxy.staticproxy;

import com.wusx.innerpower.designpattern.structural.proxy.IOrderService;
import com.wusx.innerpower.designpattern.structural.proxy.Order;
import com.wusx.innerpower.designpattern.structural.proxy.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 19:07.
 * @Modified By:
 */
@Slf4j
public class OrderServiceStaticProxy {
    private IOrderService orderService = new OrderServiceImpl();

    int save(Order order) {
        before(order);
        orderService.save(order);
        after();
        return 0;
    }

    private void before(Order order) {
        log.info("静态代理分配到before()");
        Integer userId = order.getUserId();
        int router = userId % 2;
        log.info("静态代理分配到【db" + router + "】");
        DataSourceContextHolder.setDbType("db" + String.valueOf(router));
    }


    private void after() {
        log.info("静态代理分配到after()");
    }

}
