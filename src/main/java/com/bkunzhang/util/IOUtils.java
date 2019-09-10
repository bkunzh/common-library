package com.bkunzhang.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by bkunzhang on 2019/8/11.
 */
public class IOUtils {

    /**
     * 将输入流转换为字节数组
     * @param in
     * @return
     * @throws IOException
     */
    public static byte[] inputStreamToByteArray(InputStream in) throws IOException {
        if (Objects.isNull(in)) {
            return null;
        }

        byte[] textBytes = new byte[0];
        byte[] buffer = new byte[4096];
        int len = -1;
        while ((len = in.read(buffer)) > -1) {
            textBytes = ArrayUtils.concatByteArray(textBytes, Arrays.copyOf(buffer, len));
        }
        return textBytes;
    }

    /*
     * 将输入流转换为字节数组。利用流的方式
     */
    public static byte[] inputStream2ByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int len = -1;
        do {
            len = in.read(buffer);
            if (len > 0) {
                bos.write(buffer, 0, len);
            }
        } while (len > -1);
        return bos.toByteArray();
    }


    public static void closeInputStream(InputStream in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
