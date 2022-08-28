package com.java.basic.factory.test;

public class ChicagoPizzaStore  extends PizzaStore{
    @Override
    public Pizza createPizza (String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) pizza = new ChicagoStyleCheesePizza();
        if (type.equals("peper")) pizza = new ChicagoStylePepperonuPizza();
        if (type.equals("clam")) pizza = new ChicagoStyleClamPizza();
        if (type.equals("veggie")) pizza = new ChicagoStyleVeggiePizza();

        return pizza;
    }
}
