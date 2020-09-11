package com.bkunzh.util;

import com.bkunzh.util.util.FileUtil;
import com.bkunzh.util.util.StringGenerator;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class FileUtilTest {
    // 环境变量 download_file_dir
    private final static String fileDir = System.getenv("download_file_dir");

    @Test
    public void writeStrToFile_readFileAsStr() {
        File file = new File(fileDir, "string.txt");
        for (int i=0; i<10; ++i) {
            FileUtil.writeStrToFile(file,  "str" + i);
            String str = FileUtil.readFileAsStr(file);
            System.out.println(str);
            assertEquals("str" + i, str);
        }

        final String str = "你好啊！\nCharArrayWriter caw = new CharArrayWriter();";
        final int n = 5000 * 1000; // 凑够500w个随机字符，文件也才5.5MB
        String rs = new StringGenerator(str).generateStr(n);
        FileUtil.writeStrToFile(file, rs);
        assertEquals(rs, FileUtil.readFileAsStr(file));
        System.out.println("长度为" + rs.length() + "的字符串ok");
    }
}
