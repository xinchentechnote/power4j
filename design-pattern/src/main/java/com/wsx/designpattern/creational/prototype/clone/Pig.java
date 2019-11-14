package com.wsx.designpattern.creational.prototype.clone;

import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 1:35.
 * @Modified By:
 */
@Data
@ToString
public class Pig implements Cloneable{
    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pig clone = Pig.class.cast(super.clone());
        clone.birthday = Date.class.cast(clone.birthday.clone());
        return clone;
    }
}
