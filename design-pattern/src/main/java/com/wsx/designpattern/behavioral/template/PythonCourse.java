package com.wsx.designpattern.behavioral.template;

import lombok.extern.slf4j.Slf4j;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 20:43.
 * @Modified By:
 */
@Slf4j
public class PythonCourse extends AbstractCourse {

    private boolean needWriteArticle = false;

    public PythonCourse(boolean needWriteArticle) {
        this.needWriteArticle = needWriteArticle;
    }

    @Override
    void packageCourse() {
        log.info("python");
    }

    @Override
    protected boolean needWriteArticle() {
        return this.needWriteArticle;
    }
}
