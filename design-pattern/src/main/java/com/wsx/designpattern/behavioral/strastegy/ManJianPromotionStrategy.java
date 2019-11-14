package com.wsx.designpattern.behavioral.strastegy;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:05.
 * @Modified By:
 */
public class ManJianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("满减促销");
    }
}
