package ua.nure.uvarov.Practice3.part1;

import ua.nure.uvarov.Practice3.Util;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
        System.out.println(convert1(Util.getInput("text.txt")));
        System.out.println(convert2(Util.getInput("text.txt")));
        System.out.println(convert3(Util.getInput("text.txt")));
        System.out.println(convert4(Util.getInput("text.txt")));
    }
    public static String convert1(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(.[^;]+)(?:[;])(?:.[^;]+)(?:[;])(.[^\\n]+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if ((matcher.group().compareTo("Login;Name;Email") == 1)) {
                continue;
            }
            stringBuilder.append(matcher.group(1));
            stringBuilder.append(" ==> ");
            stringBuilder.append(matcher.group(2));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
    public static String convert2(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(?mu)^(.+);(.+);(.+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if ((matcher.group().compareTo("Login;Name;Email") == 0)) {
                continue;
            }

            stringBuilder.append(matcher.group(2));
            stringBuilder.append(" (email: ");
            stringBuilder.append(matcher.group(3));
            stringBuilder.append(")");
            stringBuilder.append(System.lineSeparator());

        }
        return stringBuilder.toString();
    }
    public static String convert3(String input) {
        Pattern pattern = Pattern.compile("(?mu)^(.+);(.+);(.+)@(.+)");
        Matcher matcher = pattern.matcher(input);
        Map<String, String> hashmap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            if (hashmap.get(matcher.group(4)) != null) {
                hashmap.put(matcher.group(4), hashmap.get(matcher.group(4)) + ", " + matcher.group(2));
            }
            else {
                hashmap.put(matcher.group(4),   matcher.group(2) );
            }
        }
        for (Map.Entry<String, String> entry : hashmap.entrySet()) {
            stringBuilder.append(entry.getKey() + " ==> " + entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
    public static String convert4(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(?mu)^(.+);(.+);(.+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            if ((matcher.group().compareTo("Login;Name;Email") == 0)) {
                stringBuilder.append(matcher.group());
                stringBuilder.append(";Password");
                stringBuilder.append(System.lineSeparator());
                continue;
            }
            stringBuilder.append(matcher.group());
            stringBuilder.append(";");
            stringBuilder.append((int)(Math.random()*10));
            stringBuilder.append((int)(Math.random()*10));
            stringBuilder.append((int)(Math.random()*10));
            stringBuilder.append((int)(Math.random()*10));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
}
}