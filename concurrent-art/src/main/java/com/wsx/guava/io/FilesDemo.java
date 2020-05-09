package com.wsx.guava.io;

import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class FilesDemo {

  public static void main(String[] args) throws IOException {

    String path = "D:\\TPMODEL\\DATA\\GPS\\2020\\05\\07\\20200507_133.txt";

    File file = new File(path);
    List<String> lines = Files.readLines(file, Charset.defaultCharset());
    ByteSource byteSource = Files.asByteSource(file);
    byte[] read = byteSource.read();//
    System.out.println(lines.size());//7426

  }

}
