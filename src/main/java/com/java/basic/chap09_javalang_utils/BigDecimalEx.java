package com.java.basic.chap09_javalang_utils;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.HALF_UP;

public class BigDecimalEx {

    public static void main(String[] args) throws Exception{
        BigDecimal b1 = new BigDecimal("123.456");
        BigDecimal b2 = new BigDecimal("1.0");

        System.out.print("b1 = " + b1);
        System.out.print(",\tvalue=" + b1.unscaledValue());
        System.out.print(",\tscale=" + b1.scale());
        System.out.print(",\tprecision=" + b1.precision());
        System.out.println();

        System.out.print("b2 = " + b2);
        System.out.print(",\tvalue=" + b2.unscaledValue());
        System.out.print(",\tscale=" + b2.scale());
        System.out.print(",\tprecision=" + b2.precision());
        System.out.println();

        BigDecimal b3 = b1.multiply(b2);
        System.out.print("b3 = " + b3);
        System.out.print(",\tvalue=" + b3.unscaledValue());
        System.out.print(",\tscale=" + b3.scale());
        System.out.print(",\tprecision=" + b3.precision());
        System.out.println();

        System.out.println(b1.divide(b2, 2, HALF_UP));
        System.out.println(b1.setScale(2, HALF_UP));
        System.out.println(b1.divide(b2, new MathContext(2, HALF_UP)));
    }
}
