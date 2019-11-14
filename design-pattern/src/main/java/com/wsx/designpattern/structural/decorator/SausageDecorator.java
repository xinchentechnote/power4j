package com.wsx.designpattern.structural.decorator;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:41.
 * @Modified By:
 */
public class SausageDecorator extends AbstractDecorator {

    public SausageDecorator(AbstractBatterCake abstractBatterCake) {
        super(abstractBatterCake);
    }

    @Override
    protected String getDescription() {
        return super.getDescription() + " +香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
