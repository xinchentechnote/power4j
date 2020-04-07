package com.wsx.demospringboot;

import com.wsx.demospringboot.annotation.EnableHelloWorld;
import com.wsx.demospringboot.repository.MyRepository;
import com.wsx.demospringboot.repository.MySecondRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableHelloWorld
public class DemoSpringbootApplication {

  public static void main(String[] args) {
//    ConfigurableApplicationContext context = SpringApplication
//        .run(DemoSpringbootApplication.class, args);
    ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(
        DemoSpringbootApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);
    MyRepository myRepository = applicationContext.getBean("myRepository", MyRepository.class);
    MySecondRepository mySecondRepository = applicationContext
        .getBean("mySecondRepository", MySecondRepository.class);
    System.out.println(myRepository);
    System.out.println(mySecondRepository);
    System.out.println(applicationContext.getBean("helloWorld"));
  }

}
