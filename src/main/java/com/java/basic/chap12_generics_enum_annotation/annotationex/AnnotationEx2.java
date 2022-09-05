package com.java.basic.chap12_generics_enum_annotation.annotationex;

class NewClass {
    int newField;
    int getNewField() {return newField;}

    @Deprecated
    int oldField;

    @Deprecated
    int getOldField() {return oldField;}
}

public class AnnotationEx2 {

    public static void main(String[] args) {
        NewClass nc = new NewClass();

        nc.oldField = 10;
        System.out.println(nc.getOldField());
    }
}
