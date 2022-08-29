package com.java.basic.chap09_javalang_utils.clone;

import java.util.HashMap;

public class CloneEx2 {
    public static void main(String[] args) {
        HashMap<Integer, String> origin = new HashMap<Integer, String>();

        origin.put(1, "one");
        origin.put(2, "two");

        HashMap<Integer, String> copy = (HashMap<Integer, String>)origin.clone();

        copy.put(1, "one, one");

        for (int i : origin.keySet()) {
            System.out.println(i + ", " + origin.get(i));
        }

        for (int i : copy.keySet()) {
            System.out.println(i + ", " + copy.get(i));
        }
    }
}
