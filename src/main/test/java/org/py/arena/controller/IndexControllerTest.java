package org.py.arena.controller;

import org.junit.Test;
import org.py.jpure.core.reflect.ReflectUtils;
import org.py.jpure.support.ModelMap;

import java.lang.reflect.Method;

public class IndexControllerTest {
    @Test
    public void test() throws Exception {
        Object obj = ReflectUtils.loadAndCreate("org.py.arena.controller.IndexController");
        Method method = ReflectUtils.method(obj, "index", ModelMap.class);
        ModelMap map = new ModelMap();
        Object result = ReflectUtils.invoke(obj, method, map);
        System.out.println(result);
        System.out.println(map);
    }
}