package org.py.jpure.support;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WebRegisterModel {
    private ConcurrentMap<String, Class<?>> registerMap;

    public WebRegisterModel() {
        registerMap = new ConcurrentHashMap<>();
    }
    public void add(String url, Class<?> clazz) {
        Objects.requireNonNull(url, "require url.");
        Objects.requireNonNull(clazz, "require class.");
        registerMap.put(url, clazz);
    }
}
