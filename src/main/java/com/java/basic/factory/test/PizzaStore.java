package com.java.basic.factory.test;

public abstract class PizzaStore {
    // SimplePizzaFactory simplePizzaFactory;

    // public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
    //     this.simplePizzaFactory = simplePizzaFactory;
    // }

    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        // if (type.equals("cheese")) pizza = new CheesePizza();
        // else if (type.equals("greek")) pizza = new GreekPizza();
        // else if (type.equals("pepperoni")) pizza = new PepperoniPizza();

        // pizza = simplePizzaFactory.createPizza(type);

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        
        return pizza;
    }

    abstract Pizza createPizza(String type);
}
