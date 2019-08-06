package org.py.jpure.core.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("org.py.arena.controller.IndexController");
        Object obj = aClass.newInstance();
        Method index = aClass.getMethod("index");
        final Object invoke = index.invoke(obj);
        System.out.println(invoke);
    }
    @Test
    public void test2() {

    }
}
