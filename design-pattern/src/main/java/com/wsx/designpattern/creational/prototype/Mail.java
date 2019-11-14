package com.wsx.designpattern.creational.prototype;

import lombok.Data;
import lombok.ToString;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 1:18.
 * @Modified By:
 */
@Data
@ToString
public class Mail implements Cloneable{
    private String name;
    private String emailAddress;
    private String content;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
