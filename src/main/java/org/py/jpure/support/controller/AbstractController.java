package org.py.jpure.support.controller;

import org.py.jpure.support.ModelMap;

public class AbstractController implements Controller {
    protected ModelMap model;
    public AbstractController () {
        model = new ModelMap();
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
