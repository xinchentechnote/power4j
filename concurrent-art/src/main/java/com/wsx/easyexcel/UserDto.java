package com.wsx.easyexcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 9:40 2020/5/15.
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {


  @ExcelProperty(value = "姓名", index = 1)
  private String name;
  @ExcelProperty(value = "主鍵id", index = 0)
  private String id;
  @ExcelProperty(value = "生日", index = 2)
  private Date birthDay;
  @ExcelProperty(value = "性别", index = 3, converter = GenderConverter.class)
  private Integer gender;
  @ExcelIgnore
  private String remark;
}
