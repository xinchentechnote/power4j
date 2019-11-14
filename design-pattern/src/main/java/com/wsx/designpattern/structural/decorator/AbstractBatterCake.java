package com.wsx.designpattern.structural.decorator;

import lombok.Data;

/**.
 * @Description 抽象的被装饰者.
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 9:31.
 * @Modified By:
 */
@Data
public abstract class AbstractBatterCake {
    protected abstract String getDescription();
    protected abstract int getPrice();
}
