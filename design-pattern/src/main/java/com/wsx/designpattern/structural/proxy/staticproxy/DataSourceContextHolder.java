package com.wsx.designpattern.structural.proxy.staticproxy;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 19:13.
 * @Modified By:
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDbType(String dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    public static String getDbType() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDbType() {
        CONTEXT_HOLDER.remove();
    }
}
