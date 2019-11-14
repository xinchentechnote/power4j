package com.wsx.designpattern.creational.builder.v1;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 20:29.
 * @Modified By:
 */
public class CourseActualBuilder extends CourceBuilder {

    private Cource cource = new Cource();

    @Override
    public void builderName(String name) {
        cource.setName(name);
    }

    @Override
    public void builderPpt(String ppt) {
        cource.setPpt(ppt);

    }

    @Override
    public void builderVideo(String video) {
        cource.setVideo(video);
    }

    @Override
    public void builderArticle(String article) {
        cource.setArticle(article);
    }

    @Override
    public void builderQuestionAndAnswer(String questionAndAnswer) {
        cource.setQuestionAndAnswer(questionAndAnswer);
    }

    @Override
    public Cource build() {
        return cource;
    }
}
