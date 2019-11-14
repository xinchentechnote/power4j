package com.wsx.designpattern.structural.bridge;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 20:21.
 * @Modified By:
 */
public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是定期账号");
    }
}
