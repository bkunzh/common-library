package com.bkunzhang.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by bkunzhang on 2019/8/2.
 */
public class ReflectUtilTest {
    private int a;
    private String str;
    private ReflectUtilTest reflectUtilTest;


    @Before
    public void before() {
        reflectUtilTest = new ReflectUtilTest();
        reflectUtilTest.a = 22;
        reflectUtilTest.str = "hello world, 2019";
    }

    @Test
    public void getFieldValue() throws Exception {
        assertEquals("hello world, 2019", ReflectUtil.getFieldValue(reflectUtilTest, "str"));
        try {
            Object ccc = ReflectUtil.getFieldValue(reflectUtilTest, "ccc");
        } catch (NoSuchFieldException e) {
            System.out.println("yes");
        }
    }

    @Test
    public void getFieldValue1() throws Exception {
        Field field = String.class.getDeclaredField("value");
        try {
            Object o = ReflectUtil.getFieldValue(reflectUtilTest, field);
        } catch (IllegalArgumentException e) {
            assertEquals("field not in obj class", e.getMessage());
        }
    }

    @Test
    public void setFieldValue() throws Exception {
        assertEquals("hello world, 2019", reflectUtilTest.str);
        ReflectUtil.setFieldValue(reflectUtilTest, "str", "222");
        assertEquals("222", reflectUtilTest.str);
    }


    //field所在的类
    @Test
    public void getFieldClass() throws NoSuchFieldException {
        Field field = reflectUtilTest.getClass().getDeclaredField("str");
        assertEquals(ReflectUtilTest.class, field.getDeclaringClass());
    }

    @Test
    public void intType() throws NoSuchFieldException {
        System.out.println(ReflectUtilTest.class.getDeclaredField("a").getType());
    }


}
