package org.py.jpure.support.controller;

import org.py.jpure.support.ModelMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AbstractController implements Controller {
    protected ConcurrentMap<String, Object> model;
    public AbstractController () {
        model = new ConcurrentHashMap<>();
    }

    @Override
    public void before() {

    }

    @Override
    public void after() {

    }

    boolean checkModel(Object model) {
        return model instanceof ModelMap;
    }
}
