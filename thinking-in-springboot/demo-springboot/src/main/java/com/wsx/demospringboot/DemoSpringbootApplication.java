package com.wsx.demospringboot;

import com.wsx.demospringboot.annotation.EnableHelloWorld;
import com.wsx.demospringboot.repository.MyRepository;
import com.wsx.demospringboot.repository.MySecondRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableHelloWorld
@Slf4j
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
    log.info("{}", myRepository);
    log.info("{}", mySecondRepository);
    log.info("{}", applicationContext.getBean("helloWorld"));
  }

}
