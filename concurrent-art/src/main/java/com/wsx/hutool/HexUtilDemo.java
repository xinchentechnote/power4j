package com.wsx.hutool;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.HexUtil;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 11:24 2020/5/14.
 * @Modified By:
 */
public class HexUtilDemo {

  public static void main(String[] args) {
    byte[] bytes = new byte[]{1,64,48,3,127,5};
    String encodeHex = HexUtil.encodeHexStr(bytes);
    System.out.println(encodeHex);//01 40 30 03 7f 05
    byte[] decodeHex = HexUtil.decodeHex(encodeHex);
    System.out.println(ArrayUtil.join(decodeHex,","));//1,64,48,3,127,5
  }
}
