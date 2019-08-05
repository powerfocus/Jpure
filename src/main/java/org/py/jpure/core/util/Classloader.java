package org.py.jpure.core.util;

public final class Classloader {
    private Classloader() { }
    public static ClassLoader defaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) { }
        if(null == cl) {
            cl = Classloader.class.getClassLoader();
            if(null == cl)
                cl = ClassLoader.getSystemClassLoader();
        }
        return cl;
    }
}
