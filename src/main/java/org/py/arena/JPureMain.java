package org.py.arena;

import org.py.arena.controller.IndexController;
import org.py.jpure.core.model.JPureMap;
import org.py.jpure.support.controller.Controller;
import org.py.jpure.web.AbstractHttpApi;

public class JPureMain extends AbstractHttpApi {
    @Override
    public JPureMap<String, Class<? extends Controller>> controllerMap() {
        controllerMap.put("/index", IndexController.class);
        return super.controllerMap();
    }

    @Override
    public void body() {
        System.out.println("body in JPureMain.");
    }
}
