package org.py.jpure.web;

import org.py.jpure.core.reflect.ReflectUtils;

public class JPureCreator {
    private JPureCreator() { }
    public synchronized static JPureApi create(Class<? extends JPureApi> aClass) throws InstantiationException, IllegalAccessException {
        JPureApi jPureApi =  (JPureApi) ReflectUtils.newInstance(aClass);
        return jPureApi;
    }
}
