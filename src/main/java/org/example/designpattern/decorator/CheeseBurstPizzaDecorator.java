package org.example.designpattern.decorator;

public class CheeseBurstPizzaDecorator extends PizzaDecorator{

    public CheeseBurstPizzaDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void decorate() {
        this.pizza.decorate();
        System.out.println("add cheeseBurst");
    }
    @Override
    public double getCost() {
        return pizza.getCost()+30;
    }

}
