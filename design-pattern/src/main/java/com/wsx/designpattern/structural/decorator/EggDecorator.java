package com.wsx.designpattern.structural.decorator;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:39.
 * @Modified By:
 */
public class EggDecorator extends AbstractDecorator {
    public EggDecorator(AbstractBatterCake abstractBatterCake) {
        super(abstractBatterCake);
    }

    @Override
    protected String getDescription() {
        return super.getDescription() + " +鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
