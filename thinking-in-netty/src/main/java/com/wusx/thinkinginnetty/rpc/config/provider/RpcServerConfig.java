package com.wusx.thinkinginnetty.rpc.config.provider;

import com.wusx.thinkinginnetty.rpc.server.RpcServer;
import io.protostuff.Rpc;
import java.util.List;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:17 2020/6/21.
 * @Modified By:
 */
public class RpcServerConfig {

  private final String host = "127.0.0.1";

  private int port = 9988;

  private List<ProviderConfig> providerConfigs;

  private RpcServer rpcServer = null;


  public RpcServerConfig(
      List<ProviderConfig> providerConfigs) {
    this.providerConfigs = providerConfigs;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public void exporter() {
    if (null == rpcServer) {
      try {
        rpcServer = new RpcServer(host + ":" + port);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      for (ProviderConfig provider : providerConfigs) {
        rpcServer.registerProcessor(provider);
      }
    }

  }


}
