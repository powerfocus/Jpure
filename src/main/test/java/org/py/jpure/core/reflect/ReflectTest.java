package org.py.jpure.core.reflect;

import org.junit.Test;
import org.py.jpure.support.ModelMap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("org.py.arena.controller.IndexController");
        Object obj = aClass.newInstance();
        Method index = aClass.getMethod("index", ModelMap.class);
        final Object invoke = index.invoke(obj, new ModelMap());
        System.out.println(invoke);
    }
    @Test
    public void test2() throws Exception {
        Class<?> aClass = ReflectUtils.forName("org.py.arena.controller.IndexController");
        Object obj = ReflectUtils.newInstance(aClass);
        Method index = ReflectUtils.getMethod(aClass, "index", ModelMap.class);
        Object invoke = ReflectUtils.invoke(obj, index, new ModelMap());
        System.out.println(invoke);
    }
}
