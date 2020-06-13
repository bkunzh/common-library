package com.bkunzhang.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileUtil {
    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    public static String readFileAsStr(File file) {
        FileInputStream in = null;
        try {
            CharArrayWriter caw = new CharArrayWriter();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            char[] cbuf = new char[1024];
            int len;
            while (-1 != (len = reader.read(cbuf))) {
                caw.write(cbuf, 0, len);
            }
            return caw.toString();
        } catch (Exception e) {
            log.error("readFileAsString ", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("readFileAsString ", e);
                }
            }
        }
        return null;
    }

    public static boolean writeStrToFile(File file, String str) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(str);
            writer.flush();
            return true;
        } catch (Exception e) {
            log.error("writeStrToFile ", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    log.error("writeStrToFile ", e);
                }
            }
        }
        return false;
    }

}
