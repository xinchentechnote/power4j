package com.wsx.designpattern.structural.facade;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:12.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("phone");
        GiftExchangeService service= new GiftExchangeService();
        service.giftExchange(pointsGift);
    }
}
