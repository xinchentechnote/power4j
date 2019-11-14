package com.wsx.designpattern.structural.bridge;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 20:27.
 * @Modified By:
 */
public class ICBCBank extends Bank {
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开工商银行账号");
        account.openAccount();
        return account;
    }
}
