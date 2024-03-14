package org.check;

import java.text.DecimalFormat;

public class Compare {
    public static String textCompare(String originPath, String copyPath) {
        String origin = Read.read(originPath);
        String copy = Read.read(copyPath);

        if (origin == null || copy == null) {
            System.out.println("一个或两个文件读取失败");
            return null;
        }

        double similarity = Calculate.cal(origin, copy);

        DecimalFormat df = new DecimalFormat("0.00"); // 格式化小数
        String fSimilarity = df.format(similarity); // 格式化余弦相似度
        System.out.println("文章似度为：" + fSimilarity);

        return fSimilarity;
    }


}
