package com.wsx.designpattern.structural.adapter;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 10:21.
 * @Modified By:
 */
public class Dc5PowerAdapter implements DC5 {

    private AC220 ac220 = new AC220();

    @Override
    public int output() {
        //变压过程
        return ac220.output() / 44;
    }
}
