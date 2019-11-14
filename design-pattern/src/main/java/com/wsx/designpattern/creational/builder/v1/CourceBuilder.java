package com.wsx.designpattern.creational.builder.v1;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 20:22.
 * @Modified By:
 */

public abstract class CourceBuilder {

    public abstract void builderName(String name);
    public abstract void builderPpt(String ppt);
    public abstract void builderVideo(String video);
    public abstract void builderArticle(String article);
    public abstract void builderQuestionAndAnswer(String questionAndAnswer);

    public abstract Cource build();

}
