package com.java.basic.chap11.map;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("kimjava", new Integer(90));
        map.put("kimjava", new Integer(100));
        map.put("leejava", new Integer(100));
        map.put("kangjava", new Integer(80));
        map.put("anjava", new Integer(90));

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println("name : " + e.getKey() + ", score : " + e.getValue());
        }

        set = map.keySet();
        System.out.println("참가자 명단 : " + set);

        Collection values = map.values();
        it = values.iterator();

        int total = 0;
        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            total += i.intValue();
        }

        System.out.println("total : " + total);
        System.out.println("average : " + (float)total/set.size());
        System.out.println("max score : " + Collections.max(values));
        System.out.println("min score : " + Collections.min(values));
    }
}
