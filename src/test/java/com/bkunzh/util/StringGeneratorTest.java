package com.bkunzh.util;

import com.bkunzh.util.util.StringGenerator;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class StringGeneratorTest {
    @Test
    public void generateStr() {
        final String str = "你好啊！\nCharArrayWriter caw = new CharArrayWriter();";
        // java.lang.OutOfMemoryError: Java heap space
        // 设置vm options： -Xms777m -Xmx3888m 就不会堆溢出
        final int n = 500 * 1000 * 1000; // 5亿，554MB，
        String rs = new StringGenerator(str).generateStr(n);
        assertEquals(n, rs.length());
        System.out.println(rs.getBytes().length / 1024 / 1024 + "MB");
        System.out.println("长度为" + rs.length() + "的字符串ok");

    }
}
