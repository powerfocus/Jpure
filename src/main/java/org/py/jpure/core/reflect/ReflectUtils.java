package org.py.jpure.core.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ReflectUtils {
    private ReflectUtils() { }
    public static Class<?> forName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
    public static Object newInstance(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
    public static Object invoke(Object obj, Method method, Object... args) throws InvocationTargetException, IllegalAccessException {
        return method.invoke(obj, args);
    }
    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... args) throws NoSuchMethodException {
        return clazz.getMethod(methodName, args);
    }
    public static Object loadAndCreate(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = forName(className);
        return newInstance(aClass);
    }
    public static Method method(Object obj, String methodName, Class<?>... args) throws NoSuchMethodException {
        Class<?> aClass = obj.getClass();
        return aClass.getMethod(methodName, args);
    }
}
