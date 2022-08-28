package com.java.basic.factory.test;

public class NYPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) pizza = new NYStyleCheesePizza();
        if (type.equals("peper")) pizza = new NYStylePepperonuPizza();
        if (type.equals("clam")) pizza = new NYStyleClamPizza();
        if (type.equals("veggie")) pizza = new NYStyleVeggiePizza();

        return pizza;
    }
}
