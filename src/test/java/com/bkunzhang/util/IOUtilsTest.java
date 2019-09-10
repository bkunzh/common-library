package com.bkunzhang.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bkunzhang on 2019/8/11.
 */
public class IOUtilsTest {
    InputStream in;

    @Test
    public void inputStream2ByteArray() throws IOException {
        try {
            in = IOUtilsTest.class.getResourceAsStream("/a1.jpg");
            byte[] bytes1 = IOUtils.inputStream2ByteArray(in);
            IOUtils.closeInputStream(in);
            in = IOUtilsTest.class.getResourceAsStream("/a1.jpg");
            byte[] bytes2 = IOUtils.inputStreamToByteArray(in);

            assertArrayEquals(bytes2, bytes1);

        } finally {
            IOUtils.closeInputStream(in);
        }


        System.out.println("ok");
    }
}
