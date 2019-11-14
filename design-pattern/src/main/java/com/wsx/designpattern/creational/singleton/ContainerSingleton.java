package com.wsx.designpattern.creational.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.util.StringUtils;

/**.
 * @Description 容器单例.
 * @Author:ShangxiuWu
 * @Date: 2019/11/2 14:40.
 * @Modified By:
 */
public class ContainerSingleton {

    private static Map<String, Object> stringObjectMap = new ConcurrentHashMap<>();

    private ContainerSingleton() {
    }

    public static void putInstance(String key, Object instance) {
        if (!StringUtils.isEmpty(key) && null != instance) {
            if (!stringObjectMap.containsKey(key)) {
                stringObjectMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key) {
        return stringObjectMap.get(key);
    }
}
