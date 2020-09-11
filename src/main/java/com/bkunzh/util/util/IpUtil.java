package com.bkunzh.util.util;

import static java.lang.Long.parseLong;

public class IpUtil {

    /**
     * ip转换为long （其实int可以容纳，但会出现负数，java不支持无符号int）
     * @param ip
     * @return
     */
    public static long ip2Long(String ip) {
        String[] ipArr = ip.split("\\.");
        long ipLong = (parseLong(ipArr[0]) << 24) | (parseLong(ipArr[1]) << 16)
                | (parseLong(ipArr[2]) << 8) | parseLong(ipArr[3]);
        return ipLong;
    }

    public static String long2Ip(long ipLong) {
        String ip1 = String.valueOf((ipLong >>> 24) & 0XFF);
        String ip2 = String.valueOf((ipLong >>> 16) & 0XFF);
        String ip3 = String.valueOf((ipLong >>> 8) & 0XFF);
        String ip4 = String.valueOf(ipLong & 0XFF);
        return ip1 + "." + ip2 + "." + ip3 + "." + ip4;
    }
}
