package org.check;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ReadTest {
    @Test
    public  void  test1() {
        assertEquals("今天天气好的很你觉得呢\r\n",Read.read("C:\\Users\\Cypol\\Desktop\\1.txt"));
    }

    @Test
    public void test2() {
        //文件不存在
        Read.read("");
    }
}