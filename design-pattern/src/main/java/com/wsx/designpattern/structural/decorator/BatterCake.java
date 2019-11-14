package com.wsx.designpattern.structural.decorator;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:36.
 * @Modified By:
 */
public class BatterCake extends AbstractBatterCake {
    @Override
    protected String getDescription() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
