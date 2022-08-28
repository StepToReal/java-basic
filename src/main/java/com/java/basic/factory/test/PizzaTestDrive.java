package com.java.basic.factory.test;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        
        Pizza nyStylePizza = nyStore.createPizza("cheese");
        System.out.println(nyStylePizza.getName());
        System.out.println();

        Pizza chicagoStylePizza = chicagoStore.createPizza("cheese");
        System.out.println(chicagoStylePizza.getName());
    }     
}
