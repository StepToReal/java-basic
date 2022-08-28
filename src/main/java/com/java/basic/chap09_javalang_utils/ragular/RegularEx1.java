package com.java.basic.chap09_javalang_utils.ragular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx1 {
    
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc"};

        Pattern p = Pattern.compile("c[a-z]*");

        for (String d : data) {
            Matcher m = p.matcher(d);

            if (m.matches()) {
                System.out.println(d + ", ");
            }
        }
    }
}
