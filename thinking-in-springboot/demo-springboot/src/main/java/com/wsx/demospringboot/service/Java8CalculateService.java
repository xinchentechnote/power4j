package com.wsx.demospringboot.service;

import java.util.stream.Stream;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:51 2020/3/31.
 * @Modified By:
 */
@Service
@Profile("Java8")
public class Java8CalculateService implements CalculateService {

  @Override
  public Integer sum(Integer... values) {
    System.out.println("com.wsx.demospringboot.service.Java8CalculateService.sum");
    return Stream.of(values).reduce(0, Integer::sum);
  }
}
