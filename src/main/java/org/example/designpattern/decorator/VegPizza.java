package org.example.designpattern.decorator;

public class VegPizza  implements  Pizza{
    @Override
    public void decorate() {
        System.out.println("Veg Pizza");
    }

    @Override
    public double getCost() {
        return 10;
    }
}
