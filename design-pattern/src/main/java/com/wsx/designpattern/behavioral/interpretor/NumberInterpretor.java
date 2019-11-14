package com.wsx.designpattern.behavioral.interpretor;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:37.
 * @Modified By:
 */
public class NumberInterpretor implements Interpretor {

    private int number;

    public NumberInterpretor(int number) {
        this.number = number;
    }

    public NumberInterpretor(String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public int interpretor() {
        return this.number;
    }
}
