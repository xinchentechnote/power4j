package com.wsx.designpattern.behavioral.strastegy;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:09.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        //
        PromotionActivity activity618 = new PromotionActivity(new FanXianPromotionStrategy());
        PromotionActivity activity111 = new PromotionActivity(new ManJianPromotionStrategy());
        activity618.excutePromotionStrategy();
        activity111.excutePromotionStrategy();


        PromotionStrategy lijian = PromotionStrategyFactory.getPromotionStrategy("lijian");
        lijian.doPromotion();
    }
}
