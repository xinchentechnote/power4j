package com.wsx.designpattern.structural.facade;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:03.
 * @Modified By:
 */
public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift) {
        System.out.println("支付积分" + pointsGift);
        return true;
    }
}
