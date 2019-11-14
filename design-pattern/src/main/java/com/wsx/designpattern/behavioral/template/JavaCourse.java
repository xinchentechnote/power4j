package com.wsx.designpattern.behavioral.template;

import lombok.extern.slf4j.Slf4j;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 20:42.
 * @Modified By:
 */
@Slf4j
public class JavaCourse extends AbstractCourse {
    @Override
    void packageCourse() {
      log.info("java");
    }
}
