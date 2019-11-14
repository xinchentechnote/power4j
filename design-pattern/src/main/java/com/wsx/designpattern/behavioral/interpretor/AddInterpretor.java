package com.wsx.designpattern.behavioral.interpretor;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:32.
 * @Modified By:
 */
public class AddInterpretor implements Interpretor {

    private Interpretor firstExpression, secondExpression;

    public AddInterpretor(Interpretor firstExpression, Interpretor secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public int interpretor() {
        return firstExpression.interpretor() + secondExpression.interpretor();
    }

    @Override
    public String toString() {
        return "+";
    }
}
