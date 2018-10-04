package com.chenerzhu.learning.classloader;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author chenerzhu
 * @create 2018-10-04 10:47
 **/
public class MyClassLoader extends ClassLoader {
    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClass(name);
            if (result == null) {
                throw new ClassNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] getClass(String name) {
        try {
            return Files.readAllBytes(Paths.get(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}