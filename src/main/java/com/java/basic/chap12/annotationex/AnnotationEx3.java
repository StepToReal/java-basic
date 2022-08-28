package com.java.basic.chap12.annotationex;

import java.util.ArrayList;

class NewClass2 {
    int newField;

    int getNewField() { return newField; }

    @Deprecated
    int oldField;

    @Deprecated
    int getOldField() { return oldField; }
}

public class AnnotationEx3 {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        NewClass2 nc = new NewClass2();

        nc.oldField = 10;
        System.out.println(nc.getOldField());

        @SuppressWarnings("unchecked")
        ArrayList<NewClass2> list = new ArrayList();
        list.add(nc);
    }
}
