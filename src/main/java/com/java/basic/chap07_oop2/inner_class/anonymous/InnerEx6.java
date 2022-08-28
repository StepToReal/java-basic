package com.java.basic.chap07_oop2.inner_class.anonymous;

import java.awt.*;
import java.awt.event.*;

public class InnerEx6 {
    // Object iv = new Object() { void method() {} };
    // static Object cv = new Object() { void method() {} };

    // void myMethod() {
    //     Object lv = new Object() { void method() {} };
    // }

    public static void main(String[] args) {
        Button b = new Button("Start");
        b.addActionListener(new EventHandler());

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!!!");
            }
        });

        b.addActionListener(new EventHandler() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Anonymous instance event occurred!!");
            }
        });

        System.out.println(new AnonymousTest(1,2) {
            int c = 10;
            public int add() { return a + b + c; }
        }.add());
    }
}

class EventHandler implements ActionListener {
    public void actionPerformed (ActionEvent e) {
        System.out.println("ActionEvent occurred!!!");
    }
}

class AnonymousTest {
    int a;
    int b;

    AnonymousTest(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int add() { return a + b; }
}
