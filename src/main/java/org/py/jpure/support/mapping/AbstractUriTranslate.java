package org.py.jpure.support.mapping;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class AbstractUriTranslate implements PathTranslate {
    protected String url;
    protected final String SEPARATOR = "/";
    protected final String HOMEPATTERN = "((http|https)://)?(www.)?[^/]*/";
    protected  UrlModel model;

    public AbstractUriTranslate(String url) {
        this.url = url;
        model = new UrlModel();
    }

    @Override
    public UrlModel parser() {
        Matcher matcher = Pattern.compile(HOMEPATTERN).matcher(url);
        String home = "";
        if(matcher.find())
            home = matcher.group();
        else
            throw new IllegalStateException("illegal url.");
        String requires = url.replace(home, "").trim();
        String[] parts = requires.split("/");
        List<String> collect = Arrays.stream(parts).collect(Collectors.toList());

        return null;
    }
}
