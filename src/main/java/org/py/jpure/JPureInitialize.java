package org.py.jpure;

import org.py.arena.JPureMain;
import org.py.jpure.web.JPureApi;

public class JPureInitialize {
    private static final JPureApi jPure;
    static {
        jPure = new JPureMain();
    }
    public static JPureApi get() {
        return jPure;
    }
}
