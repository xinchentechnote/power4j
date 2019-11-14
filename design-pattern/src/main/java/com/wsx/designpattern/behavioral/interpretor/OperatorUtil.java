package com.wsx.designpattern.behavioral.interpretor;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:41.
 * @Modified By:
 */
public class OperatorUtil {

    public static boolean isOperator(String symbol) {
        return "+".equals(symbol) || "*".equals(symbol);
    }

    public static Interpretor getExpressionOperator(Interpretor first, Interpretor second, String s) {
        if ("+".equals(s)) {
            return new AddInterpretor(first, second);
        } else {
            return new MutilIterpretor(first, second);
        }

    }
}
