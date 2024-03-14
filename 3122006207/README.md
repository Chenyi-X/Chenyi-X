# 第一次个人编程作业

| 这个作业属于哪个课程 | https://edu.cnblogs.com/campus/gdgy/SoftwareEngineering2024  |
| -------------------- | ------------------------------------------------------------ |
| 这个作业要求在哪里   | https://edu.cnblogs.com/campus/gdgy/SoftwareEngineering2024/homework/13136 |
| 这个作业的目标       | 初步学习如何完成个人项目，练习编码，学习单元测试，学习使用性能分析工具Studio Profiling Tools |

---

*github地址 ： https://github.com/Chenyi-X/Chenyi-X*

## 题目

论文查重

描述如下：

设计一个论文查重算法，给出一个原文文件和一个在这份原文上经过了增删改的抄袭版论文的文件，在答案文件中输出其重复率。

- 原文示例：今天是星期天，天气晴，今天晚上我要去看电影。
- 抄袭版示例：今天是周天，天气晴朗，我晚上要去看电影。

要求输入输出采用文件输入输出，规范如下：

- 从**命令行参数**给出：论文原文的文件的**绝对路径**。
- 从**命令行参数**给出：抄袭版论文的文件的**绝对路径**。
- 从**命令行参数**给出：输出的答案文件的**绝对路径**。

我们提供一份样例，课堂上下发，上传到班级群，使用方法是：orig.txt是原文，其他orig_add.txt等均为抄袭版论文。

注意：答案文件中输出的答案为浮点型，精确到小数点后两位



## 环境

- 编程语言：Java 21
- IDE：Intellij IDEA 2023.2.2
- 项目构建工具：maven
- 单元测试：JUnit-4.13.2
- 性能分析工具：JProfiler 9.2

## SPS表格

| PSP2.1                                | Personal Software Process Stages      | 预估耗时（分钟） | 实际耗时（分钟） |
| ------------------------------------- | ------------------------------------- | ---------------- | ---------------- |
| Planning                              | 计划                                  | 30               | 25               |
| Estimate                              | 估计这个任务需要多少时间              | 150              | 240              |
| Development                           | 开发                                  | 60               | 120              |
| Analysis                              | 需求分析 (包括学习新技术)             | 45               | 90               |
| Design Spec                           | 生成设计文档                          | 15               | 20               |
| Design Review                         | 设计复审                              | 15               | 15               |
| Coding Standard                       | 代码规范 (为目前的开发制定合适的规范) | 15               | 15               |
| Design                                | 具体设计                              | 15               | 20               |
| Coding                                | 具体编码                              | 60               | 120              |
| Code Review                           | 代码复审                              | 10               | 20               |
| Test                                  | 测试（自我测试，修改代码，提交修改）  | 30               | 30               |
| Reporting                             | 报告                                  | 20               | 20               |
| Test Repor                            | 测试报告                              | 10               | 10               |
| Size Measurement                      | 计算工作量                            | 10               | 10               |
| Postmortem & Process Improvement Plan | 事后总结, 并提出过程改进计划          | 20               | 10               |
|                                       | 合计                                  | 495              |                  |

### 计算模块接口的设计与实现过程

有五个类

Main 程序入口
Read 读文本
Compare 实现比较功能
Calculate 实现计算相似度功能
Write 实现写入功能

计算相似度通过简单计算重复文字个数的占比来实现。

## 内存消耗

![image-20240314134848576](C:\Users\Cypol\AppData\Roaming\Typora\typora-user-images\image-20240314134848576.png)

内存消耗最大函数

读取并创建字符串函数

```java
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
```

改进思路：暂无。

## 测试

部分单元测试测试代码

![image-20240314135231259](C:\Users\Cypol\AppData\Roaming\Typora\typora-user-images\image-20240314135231259.png)

覆盖率91%

![image-20240314135030233](C:\Users\Cypol\AppData\Roaming\Typora\typora-user-images\image-20240314135030233.png)

单元测试思路：尽可能多覆盖行数。

## 异常处理

异常处理涵盖了用户可能出现的输入错误。

如

```java
File file = new File(path);
if (!file.exists()) {
    System.out.println("文件不存在");
    return null;
}
```