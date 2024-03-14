package org.check;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Read {
    public static String read(String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return null;
        }

        StringBuilder contentBuilder = new StringBuilder();
        try {
            //创建流，读取汉字
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);

            // 读取文件内容
            String line;
            while ((line = reader.readLine()) != null) {
                String filteredLine = filterNonChinese(line); // 过滤非汉字字符
                contentBuilder.append(filteredLine).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("读取文件出错: " + e.getMessage());
            return null;
        }

        return contentBuilder.toString();
    }

    //匹配汉字
    private static String filterNonChinese(String line) {
        Pattern pattern = Pattern.compile("[^\u4e00-\u9fa5]"); // 匹配除了汉字之外的所有字符
        Matcher matcher = pattern.matcher(line);
        return matcher.replaceAll("").trim();
    }
}
