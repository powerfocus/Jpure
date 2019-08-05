package org.py.jpure.core;

public enum Constant {
    name("Jpure"),
    version("0.1"),
    cfg("cfg"),
    templates("templates"),
    resources("public,static");
    private String val;
    private Constant(String val) {
        val = val;
    }
    public String value() {
        return val;
    }
}
