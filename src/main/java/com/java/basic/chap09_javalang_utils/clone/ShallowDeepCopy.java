package com.java.basic.chap09_javalang_utils.clone;

public class ShallowDeepCopy {
    public static void main(String[] args) {
        Circle c1 = new Circle(new PointSD(1, 1), 2.0);
        Circle c2 = c1.shallowCopy();
        Circle c3 = c1.deepCopy();

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);

        c1.p.x = 9;
        c1.p.y = 9;
        c1.r = 3.0;

        System.out.println("===c1 변경 후===");
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2); // shallowCopy 는 기본변수 변경에 독립, 참조변수 변경에는 영향 받음. 변수의 값을 복사하기 떄문.
        System.out.println("c3 = " + c3); // deepCopy 는 참조변수 변경에서 독립적임.
    }
}

class Circle implements Cloneable {
    PointSD p;
    double r;

    Circle(PointSD p, double r) {
        this.p = p;
        this.r = r;
    }

    public Circle shallowCopy() {
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        return (Circle) obj;
    }

    public Circle deepCopy() {
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        Circle c = (Circle) obj;

        if (c != null) {
            c.p = new PointSD(p.x, p.y);
        }

        return c;
    }

    public String toString() {
        return "[p=" + p + ", r=" + r + "]";
    }
}

class PointSD {
    int x, y;

    PointSD(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}
