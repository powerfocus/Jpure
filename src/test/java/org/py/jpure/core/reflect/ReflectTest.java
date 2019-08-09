package org.py.jpure.core.reflect;

import freemarker.template.Configuration;
import org.junit.Test;
import org.py.jpure.support.ModelMap;
import org.py.jpure.view.freemarker.FreemarkerTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    private Configuration cfg;
    public void before() {

    }
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
        ModelMap map = new ModelMap();
        Object invoke = ReflectUtils.invoke(obj, index, map);
        System.out.println(invoke);
        System.out.println(map);
    }
}
