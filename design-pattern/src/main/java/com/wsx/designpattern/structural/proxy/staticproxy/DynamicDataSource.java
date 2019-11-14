package com.wsx.designpattern.structural.proxy.staticproxy;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**.
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 2019/11/10 19:12.
 * @Modified By:
 */

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }
}
