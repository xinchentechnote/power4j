package com.wsx.designpattern.structural.bridge;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 20:23.
 * @Modified By:
 */
public abstract class Bank {

    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();

}
