package com.wsx.apache.lang;

import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 15:25 2020/5/13.
 * @Modified By:
 */
public class ArrayUtilsDemo {


  public static void main(String[] args) {
    int[] data = new int[]{9, 5, 2, 7};
    //数组转换为字符串
    System.out.println(ArrayUtils.toString(data));//{9,5,2,7}
    System.out.println(Arrays.toString(data));//[9, 5, 2, 7]
    //拷贝数组
    int[] clone = ArrayUtils.clone(data);
    clone[2] = 9;
    System.out.println(ArrayUtils.toString(data));//{9,5,2,7}
    System.out.println(ArrayUtils.toString(clone));//{9,5,9,7}

    boolean empty = ArrayUtils.isEmpty(data);
    System.out.println(empty);//false
    //移位
    ArrayUtils.shift(clone,1);
    System.out.println(ArrayUtils.toString(clone));//{7,9,5,9

  }

}
