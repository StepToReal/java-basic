package com.java.basic.chap09_javalang_utils;


public class CloneEx1 {
    public static void main(String[] args) {
        Point original = new Point(2,5);
        Point copy = original.clone();

        System.out.println(original.toString());
        System.out.println(copy.toString());
    }
}

class Point implements Cloneable {
    int x,y;

    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "x = " + x + ", y = " + y;
    }

    public Point clone() {
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        return (Point)obj;
    }
}
