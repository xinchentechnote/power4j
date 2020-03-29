package com.wusx.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @Description .
 * {@link java.beans.BeanInfo}实例
 * @Author:ShangxiuWu
 * @Date: 16:14 2020/3/29.
 * @Modified By:
 */
public class BeanInfoDemo {

  public static void main(String[] args) throws IntrospectionException {
    BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
    PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
    Stream<PropertyDescriptor> descriptors = Stream.of(propertyDescriptors);
    descriptors.forEach(descriptor -> {
      System.out.println(descriptor);
      Class<?> propertyType = descriptor.getPropertyType();
      String name = descriptor.getName();
      if ("age".equals(name)) {
        descriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
      }
    });
  }

  static class StringToIntegerPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      Integer integer = Integer.valueOf(text);
      setValue(integer);
    }
  }
}
