package com.wsx.demospringboot.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 17:57 2020/7/2.
 * @Modified By:
 */
@Controller
@RequestMapping("/index")
public class IndexController {

  RateLimiter limiter = RateLimiter.create(50);

  @RequestMapping("/test")
  public String test() {
    if (limiter.tryAcquire(60)) {
      return "ok";
    }
    return "failed";
  }

}
