package org.example.medium.com.vending;

import lombok.*;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Order {
    private Product product;
    private List<Double> money;
    private Double cash;

    public Order(List<Double> money, String product) {
        this.product = getProduct(product);
        this.money = money;
        cash = getCash(money);
    }

    private Double getCash(List<Double> money) {
        return money.stream().mapToDouble(Double::doubleValue).sum();
    }

    private Product getProduct(String product) {
        return Product.valueOf(product.toUpperCase());
    }
}
