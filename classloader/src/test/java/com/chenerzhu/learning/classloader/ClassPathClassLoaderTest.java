package com.chenerzhu.learning.classloader;

import org.junit.Test;

/**
 * Created by chenerzhu on 2018/10/4.
 */
public class ClassPathClassLoaderTest {

    @Test
    public void testClassPathClassLoader() throws Exception {
        //加载classPath下面所有的class和jar
        ClassPathClassLoader classPathClassLoader = new ClassPathClassLoader("C:\\Users\\chenerzhu\\Desktop");
        //Class<?> c1 = classPathClassLoader.loadClass("com.chenerzhu.learning.Test");
        //Class<?> c1 = Class.forName("com.chenerzhu.learning.Test", true, classPathClassLoader);

        //使用addClass动态添加
        /*ClassPathClassLoader classPathClassLoader=new ClassPathClassLoader();
        byte[] bytes=Files.readAllBytes(Paths.get("C:\\Users\\chenerzhu\\Desktop\\com\\chenerzhu\\learning\\Test.class"));
        classPathClassLoader.addClass("com.chenerzhu.learning.Test",bytes);*/

        Class<?> c1 = classPathClassLoader.loadClass("com.chenerzhu.learning.Test");
        Object obj = c1.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

        //不是真正卸载
        classPathClassLoader.unloadClass("com.chenerzhu.learning.Test");

        c1 = classPathClassLoader.loadClass("com.chenerzhu.learning.Test");
        Object obj1 = c1.newInstance();
        System.out.println(obj1);
        System.out.println(obj1.getClass().getClassLoader());
    }

}