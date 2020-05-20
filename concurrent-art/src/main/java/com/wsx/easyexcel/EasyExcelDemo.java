package com.wsx.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 9:39 2020/5/15.
 * @Modified By:
 */
public class EasyExcelDemo {

  private static String testFile = "D://temp//user.xlsx";

  public static void main(String[] args) throws InterruptedException {
    //
//    write();

    EasyExcel.read(testFile, UserDto.class, new UserDtoReadListener()).sheet().doRead();

  }

  private static void write() {
    Stopwatch stopwatch = Stopwatch.createStarted();
    List<UserDto> userDtos = new ArrayList<>();
    userDtos.add(new UserDto("admin", "1", new Date(), 1, "remark"));
    userDtos.add(new UserDto("test", "2", new Date(), 2, "remark"));
    userDtos.add(new UserDto("sutpc", "3", new Date(), 0, "remark"));
    userDtos.add(new UserDto("sutpc", "4", new Date(), 3, "remark"));
    EasyExcel.write(testFile, UserDto.class).sheet().doWrite(userDtos);
    stopwatch.stop();
    System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));
  }
}
