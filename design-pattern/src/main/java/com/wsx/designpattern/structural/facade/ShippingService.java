package com.wsx.designpattern.structural.facade;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:04.
 * @Modified By:
 */
public class ShippingService {
    public String shipGift(PointsGift pointsGift) {
        System.out.println("进入物流系统" + pointsGift);
        return "order no 666";
    }
}
