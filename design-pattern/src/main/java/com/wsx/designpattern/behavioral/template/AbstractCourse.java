package com.wsx.designpattern.behavioral.template;

import lombok.extern.slf4j.Slf4j;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 20:35.
 * @Modified By:
 */
@Slf4j
public abstract class AbstractCourse {

    protected final void makeCourse() {
        this.makePpt();
        this.makeVideo();
        if (this.needWriteArticle()) {
            this.writeArticle();
        }
        this.packageCourse();
    }

    final void makePpt() {
        log.info("make ppt.");
    }

    final void makeVideo() {
        log.info("make video.");
    }

    final void writeArticle() {
        log.info("write article.");
    }

    protected boolean needWriteArticle() {
        return false;
    }

    abstract void packageCourse();

}
