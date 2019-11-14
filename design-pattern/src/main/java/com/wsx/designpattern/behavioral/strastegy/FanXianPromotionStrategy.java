package com.wsx.designpattern.behavioral.strastegy;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:04.
 * @Modified By:
 */
public class FanXianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销");
    }
}
