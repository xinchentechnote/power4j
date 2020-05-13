package com.wsx.apache.collection;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;

/**
 * @Description .
 * @Author:ShangxiuWu
 * @Date: 17:54 2020/5/13.
 * @Modified By:
 */
public class MultiKeyMapDemo {

  public static void main(String[] args) {
    MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
    multiKeyMap.put("user","user1","sutpc");//被覆盖
    multiKeyMap.put("user","user1","sutpc123");
    multiKeyMap.put("user","admin","admin");
    System.out.println(multiKeyMap);//{MultiKey[user, user1]=sutpc123, MultiKey[user, admin]=admin}
    String user = multiKeyMap.get("user","user1");
    System.out.println(user);
    MapIterator<MultiKey<? extends String>, String> iterator = multiKeyMap
        .mapIterator();
    MultiKey<? extends String> next = iterator.next();
    System.out.println(next);//MultiKey[user, user1]
  }
}
