package com.wsx.demospringboot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:51 2020/3/31.
 * @Modified By:
 */
@Service
@Profile("Java7")
@Primary
public class Java7CalculateService implements CalculateService {

  @Override
  public Integer sum(Integer... values) {
    if (values == null) {
      return null;
    }
    int sum = 0;
    for (int i = 0; i < values.length; i++) {
      sum += values[i];
    }
    System.out.println("com.wsx.demospringboot.service.Java7CalculateService.sum");
    return sum;
  }
}
