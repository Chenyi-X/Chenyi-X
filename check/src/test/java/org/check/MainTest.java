package org.check;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void test1() {
        // 测试主方法
        String[] a;
        a = new String[]{"C:\\Users\\Cypol\\Desktop\\1.txt", "C:\\Users\\Cypol\\Desktop\\2.txt", "C:\\Users\\Cypol\\Desktop\\3.txt"};
        //给main参数
        Main.main(a);

    }

    @Test
    public void test2() {
        //参数不足情况
        String[] a;
        a = new String[]{"C:\\Users\\Cypol\\Desktop\\2.txt", "C:\\Users\\Cypol\\Desktop\\3.txt"};
        Main.main(a);
    }

    @Test
    public void test3() {
        //参数不足情况
        String[] a;
        a = new String[]{"C:\\Users\\Cypol\\Desktop\\3.txt"};
        Main.main(a);
    }

    @Test
    public void test4() {
        //参数不足情况
        String[] a;
        a = new String[]{};
        Main.main(a);
    }
}