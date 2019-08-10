package com.bkunzhang.util;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by bkunzhang on 2019/8/11.
 */
public class ArrayUtilsTest {
    @Test
    public void concatByteArray() {
        byte[] bytes1 = new byte[] {1, 2, 5};
        byte[] bytes2 = {11, 33, 88};
        byte[] result = ArrayUtils.concatByteArray(bytes1, bytes2);
        assertArrayEquals(new byte[] {1, 2, 5, 11, 33, 88}, result);

        assertArrayEquals(bytes2, ArrayUtils.concatByteArray(new byte[0], bytes2));
    }

    @Test
    public void inputStreamToByteArray() throws IOException {
        InputStream in = ArrayUtilsTest.class.getResourceAsStream("/a1.jpg");
        System.out.println("in.available()=" + in.available());
        byte[] bytes = IOUtils.inputStreamToByteArray(in);
        System.out.println("bytes.length=" + bytes.length);
        assertEquals(90663, bytes.length);
        IOUtils.closeInputStream(in);
    }
}
