package org.py.jpure.support.mapping;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UrlTranslateTest {
    private String hostPattern = "((http|https)://)?(www.)?[^/]*/";
    @Test
    public void test() throws IOException {
        String url = "http://www.163.com/hello/name/win10";
        StringBuilder stringBuilder = new StringBuilder(url);

        Matcher matcher = Pattern.compile(hostPattern, Pattern.CASE_INSENSITIVE).matcher(stringBuilder);
        String home = "";
        if(matcher.find())
            home = matcher.group();
        if(!home.isEmpty()) {
            System.out.println("home: " + home);
            String restpath = url.replace(home, "");
            System.out.println("upath: " + restpath);
            String[] rests = restpath.split("/");
            Arrays.stream(rests).collect(Collectors.toList()).forEach(System.out::println);
        }
    }
}