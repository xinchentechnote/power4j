package com.wsx.easyexcel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 10:03 2020/5/15.
 * @Modified By:
 */
public class GenderConverter implements Converter<Integer> {

  private static final String man = "男";
  private static final Integer manValue = 1;
  private static final String woman = "女";
  private static final Integer womanValue = 2;
  private static final String unknow = "未知";
  private static final Integer unknowValue = 0;

  @Override
  public Class supportJavaTypeKey() {
    return Integer.class;
  }

  @Override
  public CellDataTypeEnum supportExcelTypeKey() {
    return CellDataTypeEnum.STRING;
  }

  @Override
  public Integer convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
      GlobalConfiguration globalConfiguration) {
    if (man.equals(cellData.getStringValue())) {
      return 1;
    } else if (woman.equals(cellData.getStringValue())) {
      return 2;
    }
    return 0;
  }

  @Override
  public CellData convertToExcelData(Integer value, ExcelContentProperty contentProperty,
      GlobalConfiguration globalConfiguration) {
    if (manValue.equals(value)) {
      return new CellData(man);
    } else if (womanValue.equals(value)) {
      return new CellData(woman);
    }
    return new CellData(unknow);
  }

}
