package com.wsx.bilibili;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * .
 *
 * @Author:ShangxiuWu
 * @Description
 * @Date: Created in 19:52 2019/9/19 0019.
 * @Modified By:
 */
public class BiliBili {

  public static void main(String[] args) throws IOException {
    String path = "G:\\bilibili";
//    String path = "D:\\Documents\\MuMu共享文件夹";
    File[] files = new File(path).listFiles();
    for (File file : files) {
      if (file.isDirectory()) {
        System.out.print(file.getName());
        File json = new File(path + "/" + file.getName() + "/1/entry.json");
        if (json.exists()) {
          String jsonString = FileUtils.readFileToString(json, "utf-8");
          JSONObject object = JSON.parseObject(jsonString);
          String title = object.getString("title");
          System.out.println(" " + title);
        }else {
          System.out.println();
        }
      }
    }
  }

}
