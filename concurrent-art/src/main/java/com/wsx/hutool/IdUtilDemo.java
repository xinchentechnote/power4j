package com.wsx.hutool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 11:03 2020/5/14.
 * @Modified By:
 */
public class IdUtilDemo {

  public static void main(String[] args) {
    //获取随机UUID -> UUID.randomUUID().toString();
    System.out.println(IdUtil.randomUUID());//134f7bda-f6f6-4310-a0e5-fd12229b1ace
    //获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
    System.out.println(IdUtil.fastUUID());//ca14121a-37a6-4d07-904a-b68925b9cf03
    //简化的UUID，去掉了横线
    System.out.println(IdUtil.simpleUUID());//c82210d9a4cd431ab06125512139b48e
    //简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
    System.out.println(IdUtil.fastSimpleUUID());//5beb2824af0b48a485cc9234fa578279
    //创建MongoDB ID生成策略实现
    System.out.println(IdUtil.objectId());//5ebcb6d6480ca603162ea90a
    //Snowflake算法
    Snowflake snowflake = IdUtil.createSnowflake(1, 1);
    for (int i = 0; i < 10; i++) {
      System.out.println(snowflake.nextIdStr());
        /*
          1260769630977396736
          1260769630977396737
          1260769630977396738
          1260769630977396739
          1260769630977396740
          1260769630977396741
          1260769630977396742
          1260769630977396743
          1260769630977396744
          1260769630977396745
         */
    }
  }
}
