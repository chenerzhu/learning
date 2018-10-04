package com.chenerzhu.learning.classloader;

import org.junit.Test;

/**
 * Created by chenerzhu on 2018/10/4.
 */
public class MyClassLoaderTest {
    @Test
    public void testClassLoader() throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("src/test/resources/bean/Hello.class");
        Class clazz = myClassLoader.loadClass("com.chenerzhu.learning.classloader.bean.Hello");
        Object obj = clazz.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
    }
}