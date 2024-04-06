package org.example.designpattern.decorator;

public class Context {
    public static void main(String[] args) {
        Pizza pizza = new WhiteSauseDecorator(new CheeseBurstPizzaDecorator(new VegPizza()));
        pizza.decorate();
        System.out.println(pizza.getCost());
    }
}
