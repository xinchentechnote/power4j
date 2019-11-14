package com.wsx.designpattern.behavioral.strastegy;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:07.
 * @Modified By:
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void excutePromotionStrategy() {
        promotionStrategy.doPromotion();
    }

}
