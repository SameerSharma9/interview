package org.example.designpattern.decorator;

public class WhiteSauseDecorator extends PizzaDecorator{

    public WhiteSauseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void decorate() {
        this.pizza.decorate();
        System.out.println("add alfredo sauce");
    }

    @Override
    public double getCost() {
        return pizza.getCost()+20;
    }
}
