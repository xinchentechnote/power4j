package com.wsx.hutool;

import cn.hutool.core.util.IdcardUtil;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 11:14 2020/5/14.
 * @Modified By:
 */
public class IdcardUtilDemo {

  public static void main(String[] args) {
    String idcard1 = "440982199901014101";
    System.out.println(IdcardUtil.isValidCard(idcard1));//false
    System.out.println(IdcardUtil.getBirth(idcard1));//19990101
    System.out.println(IdcardUtil.getAgeByIdCard(idcard1));//21
    System.out.println(IdcardUtil.getGenderByIdCard(idcard1));//0 ,性别(1: 男，0: 女)
  }
}
