package org.example.medium.com.vending;

public enum Product {
    CANDY(10),
    SNACK(50),
    NUTS(90),
    Coke(25),
    Pepsi(35),
    Soda(45);

    private int price;

    Product(int price) {
        this.price = price;
    }

    int getPrice() {
        return price;
    }

}
