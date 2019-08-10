package com.bkunzhang.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by bkunzhang on 2019/8/11.
 */
public class ArrayUtils {
    /**
     * 两个数组拼接成一个新数组
     *
     * @param bytes1
     * @param bytes2
     * @return
     */
    public static byte[] concatByteArray(byte[] bytes1, byte[] bytes2) {
        byte[] result = new byte[bytes1.length + bytes2.length];
        System.arraycopy(bytes1, 0, result, 0, bytes1.length);
        System.arraycopy(bytes2, 0, result, bytes1.length, bytes2.length);
        return result;
    }




}
