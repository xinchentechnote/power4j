package com.wsx.designpattern.creational.singleton;

/**.
 * @Description 既可以反正序列化安全问题，又可以防止反射攻击 .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 14:30.
 * @Modified By:
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
