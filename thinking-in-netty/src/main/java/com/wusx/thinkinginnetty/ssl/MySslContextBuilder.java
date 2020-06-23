package com.wusx.thinkinginnetty.ssl;

import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.synchronoss.cloud.nio.multipart.util.IOUtils;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 11:35 2020/6/23.
 * @Modified By:
 */
@Slf4j
public class MySslContextBuilder {

  private final static String serverCrt = "ssl/server.crt";
  private final static String serverKey = "ssl/pkcs8_server.key";
  private final static String caCrt = "ssl/ca.crt";
  private final static String keyPassword = "sutpc123";

  public static SslContext build(ClientAuth clientAuth) {
    InputStream certInput = null;
    InputStream priKeyInput = null;
    InputStream caInput = null;
    try {
      certInput = new ClassPathResource(serverCrt).getInputStream();
      priKeyInput = new ClassPathResource(serverKey).getInputStream();
      caInput = new ClassPathResource(caCrt).getInputStream();
      return SslContextBuilder
          //双向校验
          .forServer(certInput, priKeyInput)
          .clientAuth(clientAuth)
          //校验对方证书
          .trustManager(caInput).build();
    } catch (Throwable e) {
      log.error("HidsSslContextBuilder", e);
    } finally {
      IOUtils.closeQuietly(certInput);
      IOUtils.closeQuietly(priKeyInput);
      IOUtils.closeQuietly(caInput);
    }
    return null;
  }


  public static SslContext buildSelfSignedCer() {
    try {
      SelfSignedCertificate ssc = new SelfSignedCertificate();
      return SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey())
          .build();
    } catch (Throwable e) {
      log.error("buildSelfSignedCer", e);
    }
    return null;
  }

}
