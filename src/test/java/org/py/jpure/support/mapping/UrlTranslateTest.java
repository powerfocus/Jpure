package org.py.jpure.support.mapping;

import org.apache.commons.text.RandomStringGenerator;
import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.WordUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    @Test
    public void test2() {
        String url = "hello/world/user/password/win10";
        Matcher matcher = Pattern.compile("[^/]+/?").matcher(url);
        while(matcher.find()) {
             String group = matcher.group();
        }
    }
    @Test
    public void test3() {
        String name = "powerfocus";
        System.out.println(WordUtils.capitalize(name.trim()));
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z').build();
        String randomLetters = generator.generate(20);
        System.out.println(randomLetters);

        Map valuesMap = new HashMap();
        valuesMap.put("animal", "quick brown fox");
        valuesMap.put("target", "lazy dog");
        String templateString = "The ${animal} jumped over the ${target}.";
        StringSubstitutor sub = new StringSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        System.out.println(resolvedString);
    }
}