package com.wusx.thinkinginnetty.rpc.codec;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 21:19 2020/6/21.
 * @Modified By:
 */
public class Serialization {

  private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();
  private static Objenesis objenesis = new ObjenesisStd(true);


  private static <T> Schema<T> getSchema(Class<T> clazz) {

    Schema<T> schema = (Schema<T>) cachedSchema.get(clazz);
    if (null == schema) {
      schema = RuntimeSchema.createFrom(clazz);
      if (null != schema) {
        cachedSchema.put(clazz, schema);
      }
    }
    return schema;
  }

  /**
   *@Description 序列化.
   *@Author wusx
   *@Date 14:58 2020/6/25
   *@Modified
   */
  public static <T> byte[] serialize(T obj) {
    Class<T> clazz = (Class<T>) obj.getClass();
    LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
    try {
      Schema<T> schema = getSchema(clazz);
      return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
    } catch (Exception e) {
      throw new IllegalStateException(e.getMessage(), e);
    } finally {
      buffer.clear();
    }

  }

  /**
   *@Description 返序列化.
   *@Author  wusx
   *@Date 15:02 2020/6/25
   *@Modified
   */
  public static <T> T deserialize(byte[] data, Class<T> clazz) {
    try {

      T message = objenesis.newInstance(clazz);
      Schema<T> schema = getSchema(clazz);
      ProtostuffIOUtil.mergeFrom(data, message, schema);
      return message;
    } catch (Exception e) {
      throw new IllegalStateException(e.getMessage(), e);
    }
  }

}
