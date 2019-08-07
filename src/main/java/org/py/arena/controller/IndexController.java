package org.py.arena.controller;

import org.py.jpure.support.ModelMap;
import org.py.jpure.support.controller.AbstractController;

public class IndexController extends AbstractController {
    public String index(ModelMap map) {
        map.put("title", "home");
        map.put("os", "win10");
        map.put("name", "microsoft");
        return "index/home";
    }
}
