package com.wusx.thinkinginnetty.rpc.test.provider;

import com.wusx.thinkinginnetty.rpc.config.provider.ProviderConfig;
import com.wusx.thinkinginnetty.rpc.config.provider.RpcServerConfig;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 13:32 2020/6/26.
 * @Modified By:
 */
public class ProviderStarter {

  public static void main(String[] args) {
    try {

      ProviderConfig config = new ProviderConfig();
      config.setInterfaceClass("com.wusx.thinkinginnetty.rpc.test.consumer.HelloService");
      config.setRef(HelloServiceImpl.class.newInstance());

      List<ProviderConfig> configs = new ArrayList<>();
      configs.add(config);

      RpcServerConfig serverConfig = new RpcServerConfig(configs);
      serverConfig.exporter();

    } catch (Exception e) {
    }

  }
}
