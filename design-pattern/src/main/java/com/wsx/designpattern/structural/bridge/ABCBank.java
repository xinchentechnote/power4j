package com.wsx.designpattern.structural.bridge;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 20:26.
 * @Modified By:
 */
public class ABCBank extends Bank {
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开农业银行账号");
        account.openAccount();
        return account;
    }
}
