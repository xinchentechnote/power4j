package com.wsx.designpattern.behavioral.strastegy;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:15.
 * @Modified By:
 */
public class DefaultPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("默认策略");
    }
}
