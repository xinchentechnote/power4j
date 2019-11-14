package com.wsx.designpattern.creational.simplefactory;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 23:11.
 * @Modified By:
 */
public class VideoFactory {
    public Video getVideo(String type) {
        if ("java".equals(type)) {
            return new JavaVideo();
        } else if ("java".equals(type)) {
            return new PythonVideo();
        } else {
            return null;
        }
    }

    public Video getVideo(Class clazz) {
        if (null != clazz && Video.class.isAssignableFrom(clazz)) {
            try {
                Video video = Video.class.cast(Class.forName(clazz.getName()).newInstance());
                return video;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
