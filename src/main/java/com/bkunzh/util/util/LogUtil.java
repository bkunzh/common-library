package com.bkunzh.util.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author bkunzhang
 * @date 2019/9/15
 */
public class LogUtil {
    public static String getStackTraceInfo(Throwable throwable) {
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
