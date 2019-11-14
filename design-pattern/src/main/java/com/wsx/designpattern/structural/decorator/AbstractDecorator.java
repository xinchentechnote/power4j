package com.wsx.designpattern.structural.decorator;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:37.
 * @Modified By:
 */
public abstract class AbstractDecorator extends AbstractBatterCake {
    private AbstractBatterCake abstractBatterCake;

    public AbstractDecorator(AbstractBatterCake abstractBatterCake) {
        this.abstractBatterCake = abstractBatterCake;
    }

    @Override
    protected String getDescription() {
        return abstractBatterCake.getDescription();
    }

    @Override
    protected int getPrice() {
        return abstractBatterCake.getPrice();
    }
}
