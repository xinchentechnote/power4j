package com.wsx.demospringboot.annotation;

import com.wsx.demospringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description {@link ImportSelector} 实现demo.
 * @Author:ShangxiuWu
 * @Date: 22:33 2020/3/31.
 * @Modified By:
 */
public class HelloWorldImportSelector implements ImportSelector{

  @Override
  public String[] selectImports(AnnotationMetadata annotationMetadata) {
    return new String[]{"com.wsx.demospringboot.configuration.HelloWorldConfiguration"};
  }
}
