package org.py.jpure.web;

import org.py.arena.JPureMain;

public class JPureAdapter {
    private static final JPureMain jPureMain;
    static {
        jPureMain = new JPureMain();
    }
    public JPureMain instance() {
        return jPureMain;
    }
}
