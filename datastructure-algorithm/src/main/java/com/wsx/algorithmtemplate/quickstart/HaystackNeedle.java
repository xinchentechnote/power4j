package com.wsx.algorithmtemplate.quickstart;

/**.
 * @Description 大海捞针.
 * @Author:ShangxiuWu
 * @Date: 21:51 2020/6/21.
 * @Modified By:
 */
public class HaystackNeedle {

  public static void main(String[] args) {
    System.out.println(findNeedle("hello wword", "woi"));
  }

  /**
   *@Description .
   *@params 在$haystack字符串中查找第一个$needle, 找不到返回-1
   *@Author wusx
   *@Date 21:54 2020/6/21
   *@Modified
   */
  public static int findNeedle(String haystack, String needle) {
    if (null == needle || needle.length() == 0) {
      return -1;
    }
    if (null == needle || needle.length() == 0) {
      return -1;
    }
    char[] haystackCharArr = haystack.toCharArray();
    char[] needleCharArr = needle.toCharArray();
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      for (int j = 0; j < needle.length(); j++) {
        if (haystackCharArr[i + j] != needleCharArr[j]) {
          break;
        }
        if (j == needle.length() - 1) {
          return i;
        }
      }
    }
    return -1;
  }

}
