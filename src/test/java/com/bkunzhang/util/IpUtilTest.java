package com.bkunzhang.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Mysql的IP转换函数
 * inet_aton:将ip地址转换成数字型
 * inet_ntoa:将数字型转换成ip地址
 *
 * IP：如192.168.12.145，在存储时，若是采用varchar进行存储，存在两个主要缺点：
 * 存储空间占用较大；
 * 查询检索较慢；
 *
 * 解决方式：
 * 存储时：将字符串类型的IP转换为整型进行存储；
 * 查询时：将整型的IP转换为字符串；
 *
 * select inet_aton('127.2.2.101');
 * SELECT inet_ntoa(2130838117);
 */
public class IpUtilTest {

    @Test
    public void t1() {
        String ip = "128.2.2.101";
        assertEquals(2147615333L, IpUtil.ip2Long(ip));

        ip = "127.2.2.102";
        assertEquals(2130838118L, IpUtil.ip2Long(ip));

        long ipLong = 2130838118L;
        assertEquals("127.2.2.102", IpUtil.long2Ip(ipLong));

        ipLong = 2147615333L;
        assertEquals("128.2.2.101", IpUtil.long2Ip(ipLong));

    }

    @Test
    public void ip2Long() {
//        String ip = "192.168.2.101";
        String ip = "128.2.2.101";
        String[] ipArr = ip.split("\\.");
        // ip转为int会为负数，当第一个ip段>=128时
        long ipLong = 0;
        for (int i=3; i>=0; --i) {
            long num = Integer.parseInt(ipArr[i]);
            num <<= (3 - i) * 8;
            ipLong |= num;
        }
        System.out.println(ipLong);
        System.out.println((int) ipLong);

        // long int
        long lo = 3232236133L;
        System.out.println(lo + ", " + (int)lo);
    }

    @Test
    public void ip2Int() {
//        String ip = "192.168.2.101";
        String ip = "128.2.2.101";
//        String ip = "127.2.2.101";
        String[] ipArr = ip.split("\\.");
        int ipInt = 0;
        for (int i=3; i>=0; --i) {
            int num = Integer.parseInt(ipArr[i]);
            num <<= (3 - i) * 8;
            ipInt |= num;
        }
        System.out.println(ipInt);
        System.out.println((long) ipInt);
    }

    @Test
    public void bitOper() {
        int i = 1;
        System.out.println(i << 8);
        System.out.println(i << 16);
        System.out.println(i << 32);
        System.out.println(i << 33);
        System.out.println(i << 31);
        System.out.println((i << 31) - 1);
        System.out.println(0x7FFFFFFF);
        System.out.println(Integer.MAX_VALUE);
    }
}