package com.wsx.demospringboot.bootstrap;

import com.wsx.demospringboot.repository.MyRepository;
import com.wsx.demospringboot.repository.MySecondRepository;
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
@ComponentScan(basePackages = "com.wsx.demospringboot.repository")
public class RepositoryBootstrap {

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(
        RepositoryBootstrap.class)
        .web(WebApplicationType.NONE)
        .run(args);
    MyRepository myRepository = applicationContext.getBean("myRepository", MyRepository.class);
    MySecondRepository mySecondRepository = applicationContext
        .getBean("mySecondRepository", MySecondRepository.class);
    System.out.println(myRepository);
    System.out.println(mySecondRepository);
  }
}
