package org.py.arena.controller;

import org.py.jpure.support.ModelMap;
import org.py.jpure.support.controller.AbstractController;

public class IndexController extends AbstractController {
    public String index(ModelMap map) {
        System.out.println("IndexController index().");
        map.put("os", "win10");
        map.put("name", "microsoft");
        return "<h1>hello world.</h1>";
    }
}
