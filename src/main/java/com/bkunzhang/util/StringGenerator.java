package com.bkunzhang.util;

import java.util.Random;

/**
 * 随机字符产生器，根据提供的种子集，产生指定长度的字符串
 */
public class StringGenerator {
    private String str;
    public StringGenerator(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("不能提供空串种子");
        }
        this.str = str;
    }

    /**
     * 生成长度为len的随机字符串
     * @param len
     * @return
     */
    public String generateStr(int len) {
        final char[] chars = str.toCharArray();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < len) {
            stringBuilder.append(chars[random.nextInt(chars.length)]);
        }
        return stringBuilder.toString();
    }
}
