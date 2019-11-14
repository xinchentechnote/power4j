package com.wsx.designpattern.structural.facade;

import lombok.Data;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:06.
 * @Modified By:
 */
@Data
public class GiftExchangeService {

    private QualifyService qualifyService = new QualifyService();
    private PointsPaymentService pointsPaymentService = new PointsPaymentService();
    private ShippingService shippingService = new ShippingService();

    public void giftExchange(PointsGift pointsGift) {
        if (qualifyService.isAvailable(pointsGift)) {
            //资格校验成功
            if (pointsPaymentService.pay(pointsGift)) {
                //支付成功
                String orderNo = shippingService.shipGift(pointsGift);
                System.out.println("物流系统下单成功，"+orderNo);
            }
        }
    }

}
