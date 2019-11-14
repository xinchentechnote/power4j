package com.wsx.designpattern.structural.bridge;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 20:32.
 * @Modified By:
 */
public class Main {

    public static void main(String[] args) {
        Bank icbcBank= new ICBCBank(new DepositAccount());
        Account account = icbcBank.openAccount();
        account.showAccountType();
    }
}
