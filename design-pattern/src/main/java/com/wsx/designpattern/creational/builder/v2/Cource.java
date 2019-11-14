package com.wsx.designpattern.creational.builder.v2;

import lombok.Data;
import lombok.ToString;

/**.
 * @Description 静态内部类实现.
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 20:18.
 * @Modified By:
 */
@Data
@ToString
public class Cource {
    private String name;
    private String ppt;
    private String video;
    private String article;

    private String questionAndAnswer;

    public Cource(CourceBuilder courceBuilder) {
        this.name = courceBuilder.name;
        this.ppt = courceBuilder.ppt;
        this.video = courceBuilder.video;
        this.article = courceBuilder.article;
        this.questionAndAnswer = courceBuilder.questionAndAnswer;
    }


    public static class CourceBuilder {

        private String name;
        private String ppt;
        private String video;
        private String article;

        private String questionAndAnswer;

        public CourceBuilder builderName(String name) {
            this.name = name;
            return this;
        }

        public CourceBuilder builderPpt(String ppt) {
            this.ppt = ppt;
            return this;
        }

        public CourceBuilder builderVideo(String video) {
            this.video = video;
            return this;
        }

        public CourceBuilder builderArticle(String article) {
            this.article = article;
            return this;
        }

        public CourceBuilder builderQuestionAndAnswer(String questionAndAnswer) {
            this.questionAndAnswer = questionAndAnswer;
            return this;
        }

        public Cource build() {
            return new Cource(this);
        }

    }
}
