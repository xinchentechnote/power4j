package com.wsx.demospringboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description 系统属性参数配置.
 * @Author:ShangxiuWu
 * @Date: 23:14 2020/3/31.
 * @Modified By:
 */
public class OnSystemPropertyCondition implements Condition {

  @Override
  public boolean matches(ConditionContext conditionContext,
      AnnotatedTypeMetadata annotatedTypeMetadata) {
    return false;
  }
}
