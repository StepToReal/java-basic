package com.java.basic.chap12.annotationex;

class Parent {
    void parentMethod() {}
}

class Child extends Parent {
    @Override
    void parentMethod() {}
}

public class AnnotationEx1 {
}
