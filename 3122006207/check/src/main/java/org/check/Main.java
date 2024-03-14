package org.check;

public class Main {
    public static void main(String[] args) {

        //参数量错误报错并退出
        if  (args.length != 3) {

            System.out.println("参数数量错误");

        } else {

            String originPath = args[0];
            String copyPath = args[1];
            String outputPath = args[2];

            System.out.println("论文原文的文件的绝对路径" + originPath);
            System.out.println("抄袭版论文的文件的绝对路径" + copyPath);
            System.out.println("输出的答案文件的绝对路径" + outputPath);

            Write.resultWrite(Compare.textCompare(originPath, copyPath), outputPath);

            System.out.println("论文相似度检测完成");
        }
    }
}