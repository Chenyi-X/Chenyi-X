package org.check;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompareTest {
    @Test
    public void testCompare() {
        // 测试Compare类的compare方法

        //文件不存在
        Compare.textCompare("C:\\Users\\Cypol\\Desktop\\1.txt","");

        //比较成功
        Compare.textCompare("C:\\Users\\Cypol\\Desktop\\1.txt","C:\\Users\\Cypol\\Desktop\\2.txt");
    }
}