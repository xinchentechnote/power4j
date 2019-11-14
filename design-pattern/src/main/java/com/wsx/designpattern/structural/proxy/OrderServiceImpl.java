package com.wsx.designpattern.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 19:04.
 * @Modified By:
 */
@Slf4j
public class OrderServiceImpl implements IOrderService {

    private IOrderDao orderDao = new OrderDaoImpl();

    @Override
    public int save(Order order) {
        log.info("save {}", order);
        return orderDao.save(order);
    }
}
