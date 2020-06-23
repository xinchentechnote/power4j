package com.wusx.thinkinginnetty.ssl;

import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import java.io.File;
import java.util.Properties;
import org.apache.logging.log4j.util.PropertiesUtil;

/**
 * @Description sslContext工厂类.
 * @Author:wusx
 * @Date 10:54 2020/6/23
 * @Modified
 */
public class SslContextFactory {

  private static SslContext SERVER_CONTEXT;
  private static SslContext CLIENT_CONTEXT;

  private static final String SERVER_CERT_CHAIN_FILE_PATH = "D:\\ssl\\servercrt.pem";
  private static final String SERVER_KEY_FILE_PATH = "D:\\ssl\\pkcs8_serverkey.pem";
  private static final String CLIENT_CERT_CHAIN_FILE_PATH = "D:\\ssl\\clientcrt.pem";
  private static final String CLIENT_KEY_FILE_PATH = "D:\\ssl\\pkcs8_clientkey.pem";
  private static final String ROOT_FILE_PATH = "D:\\ssl\\cacrt.pem";
  private static final String ROOT_KEY_FILE_PATH = "D:\\ssl\\pkcs8_cakey.pem";

  public static SslContext getServerContext() {

    try {
      File certChainFile = new File(SERVER_CERT_CHAIN_FILE_PATH);
      File keyFile = new File(SERVER_KEY_FILE_PATH);
      File rootFile = new File(ROOT_FILE_PATH);
      File rootKeyFile = new File(ROOT_KEY_FILE_PATH);
      SERVER_CONTEXT = SslContextBuilder.forServer(certChainFile, keyFile)
          .trustManager(rootFile).clientAuth(ClientAuth.REQUIRE).build();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return SERVER_CONTEXT;
  }

  public static SslContext getClientContext() {

    try {
      File certChainFile = new File(CLIENT_CERT_CHAIN_FILE_PATH);
      File keyFile = new File(CLIENT_KEY_FILE_PATH);
      File rootFile = new File(ROOT_FILE_PATH);
      File rootKeyFile = new File(ROOT_KEY_FILE_PATH);
      CLIENT_CONTEXT = SslContextBuilder.forClient().keyManager(certChainFile, keyFile)
          .trustManager(rootFile).build();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return CLIENT_CONTEXT;
  }


  private SslContextFactory() {

  }

}
