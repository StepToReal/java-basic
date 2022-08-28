package com.java.basic.factory.test;

public class SimplePizzaFactory {
    
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) pizza = new CheesePizza();
        if (type.equals("greek")) pizza = new GreekPizza();
        if (type.equals("pepperoni")) pizza = new PepperoniPizza();

        return pizza;
    }
}
