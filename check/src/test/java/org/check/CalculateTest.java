package org.check;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTest {
    @Test
    public void test1 (){
        double a =  Calculate.cal("你好","你好");
        assertEquals(1,a,0);
    }
}