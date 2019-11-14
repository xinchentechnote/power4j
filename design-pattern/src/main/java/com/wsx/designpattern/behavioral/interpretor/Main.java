package com.wsx.designpattern.behavioral.interpretor;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 22:29.
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
        String symbol = "3 66 99 100 * + *";
        MyExpressionParser parser = new MyExpressionParser();
        System.out.println(parser.parse(symbol));

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("100*3");
        System.out.println(expression.getValue());
    }
}
