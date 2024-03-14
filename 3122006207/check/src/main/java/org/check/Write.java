package org.check;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class Write {
    public static void resultWrite(String text, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(text);
            writer.close();
            System.out.println("写入成功");
        } catch (IOException e) {
            System.out.println("写入文件时出错：" + e.getMessage());
        }
    }
}