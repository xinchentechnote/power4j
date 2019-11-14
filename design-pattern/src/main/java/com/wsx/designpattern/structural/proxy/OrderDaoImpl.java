package com.wsx.designpattern.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 19:02.
 * @Modified By:
 */
@Slf4j
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int save(Order order) {
        log.info("save {}", order);
        return 1;
    }
}
