package com.wsx.demospringboot.bootstrap;

import com.wsx.demospringboot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 22:57 2020/3/31.
 * @Modified By:
 */
@ComponentScan(basePackages = "com.wsx.demospringboot.service")
public class CalculateServiceBootstrap {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(
        CalculateServiceBootstrap.class)
        .profiles("Java8","Java7")
        .web(WebApplicationType.NONE)
        .run(args);
    CalculateService service = context.getBean(CalculateService.class);

    Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(service.sum(arr));

  }
}
