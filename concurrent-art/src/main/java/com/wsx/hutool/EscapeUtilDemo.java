package com.wsx.hutool;

import cn.hutool.core.util.EscapeUtil;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 15:39 2020/5/14.
 * @Modified By:
 */
public class EscapeUtilDemo {

  public static void main(String[] args) {
    System.out.println(EscapeUtil.escape("hello world"));//hello%20world
    System.out.println(EscapeUtil.escapeHtml4("hello world"));//hello%20world

    String escapeHtml4 = EscapeUtil.escapeHtml4("<a>你好</a>");
    System.out.println(escapeHtml4);//&lt;a&gt;你好&lt;/a&gt;
    String result = EscapeUtil.unescapeHtml4("&#25391;&#33633;&#22120;&#31867;&#22411;");
    System.out.println(result);//振荡器类型
  }
}
