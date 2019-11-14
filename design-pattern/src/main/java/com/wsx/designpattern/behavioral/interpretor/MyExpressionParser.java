package com.wsx.designpattern.behavioral.interpretor;

import java.util.Stack;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:39.
 * @Modified By:
 */
public class MyExpressionParser {
    private Stack<Interpretor> stack = new Stack<>();

    public int parse(String str) {
        String[] strArr = str.split(" ");
        for (String s : strArr) {
            if (!OperatorUtil.isOperator(s)) {
                Interpretor numberExpression = new NumberInterpretor(s);
                stack.push(numberExpression);
                System.out.println(String.format("入栈：%d", numberExpression.interpretor()));
            } else {
                Interpretor first = stack.pop();
                Interpretor second = stack.pop();
                System.out.println(String.format("出栈：%d 和 %d", first.interpretor(), second.interpretor()));
                Interpretor operator = OperatorUtil.getExpressionOperator(first, second, s);
                int result = operator.interpretor();
                NumberInterpretor resultInterpretor = new NumberInterpretor(result);
                stack.push(resultInterpretor);
                System.out.println(String.format("阶段结果入栈：%d", resultInterpretor.interpretor()));
            }
        }
        int result = stack.pop().interpretor();
        return result;
    }

}
