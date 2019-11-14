package com.wsx.designpattern.creational.builder.v1;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 20:32.
 * @Modified By:
 */
public class Coach {
    private CourceBuilder courceBuilder;

    public Coach(CourceBuilder courceBuilder) {
        this.courceBuilder = courceBuilder;
    }

    public Cource makeCource(String name, String ppt, String video, String article, String questionAndAnswer) {
        this.courceBuilder.builderName(name);
        this.courceBuilder.builderPpt(ppt);
        this.courceBuilder.builderVideo(video);
        this.courceBuilder.builderArticle(article);
        this.courceBuilder.builderQuestionAndAnswer(questionAndAnswer);
        return this.courceBuilder.build();
    }

}
