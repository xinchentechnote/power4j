package com.wsx.designpattern.creational.builder.v1;

import lombok.Data;
import lombok.ToString;

/**.
 * @Description .
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

}
