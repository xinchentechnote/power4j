package com.wsx.designpattern.creational.prototype;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/3 1:20.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化");
        for (int i = 0; i < 10; i++) {
            Mail temp = Mail.class.cast(mail.clone());
            temp.setName("name"+i);
            temp.setEmailAddress("email"+i);
            temp.setContent("nihao"+i);
            MailUtil.sendMail(temp);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
