package com.wsx.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.read.listener.ReadListener;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 10:41 2020/5/15.
 * @Modified By:
 */
@Slf4j
public class UserDtoReadListener implements ReadListener<UserDto> {

  @Override
  public void onException(Exception exception, AnalysisContext context) throws Exception {
    log.error("exception {}", exception.getMessage());
  }

  @Override
  public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
    log.info("{}", headMap);
  }

  @Override
  public void invoke(UserDto data, AnalysisContext context) {
    System.out.println(data);
  }

  @Override
  public void doAfterAllAnalysed(AnalysisContext context) {
    log.info("read finish...");
  }

  @Override
  public boolean hasNext(AnalysisContext context) {
    return true;
  }
}
