package org.py.jpure.support.mapping;

public abstract class AbstractUriTranslate implements PathTranslate {
    protected String url;
    protected final String SEPARATOR = "/";
    protected final String HOMEPATTERN = "((http|https)://)?(www.)?[^/]*/";
    protected  UrlModel urlModel;

    public AbstractUriTranslate(String url) {
        this.url = url;
        urlModel = new UrlModel();
    }

    @Override
    public UrlModel parser() {
        return null;
    }
}
