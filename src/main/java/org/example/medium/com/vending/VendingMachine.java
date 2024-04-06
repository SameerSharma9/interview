package org.example.medium.com.vending;

//https://medium.com/javarevisited/top-10-object-oriented-analysis-and-design-interview-questions-and-problems-for-experienced-6c3a53b7cb26

import lombok.Data;

import java.util.List;

/**
 * You need to design a Vending Machine which follows the following requirements:
 * 1. It should accepts coins of 1,5,10,25, 50 Cents, i.e., penny, nickel, dime, and quarter as well as 1 and 2 dollar note
 *
 * 2. Allow user to select products like CANDY(10), SNACK(50), NUTS(90), Coke(25), Pepsi(35), Soda(45)
 *
 * 3. Allow users to take a refund by canceling the request.
 *
 * 4. Return the selected product and remaining change if any
 *
 * 5. Allow reset operation for vending machine supplier
 */

@Data
public class VendingMachine {
    private Integer capacity;
    private Double moneyCollected;
    private List<Product> inventory;

    public boolean dispenseProduct(Product prod, Double cash) {
        if(!inventory.contains(prod)) {
            System.out.println("Product not available.");
            //throw new ProductNotAvailableException("Product not available.");
            return false;
        }
        if(prod.getPrice() > cash) {
            System.out.println("Insufficient Money");
            //throw new ProductNotAvailableException("Insufficient Money");
            return false;
        }
        inventory.remove(prod);
        capacity--;
        moneyCollected += prod.getPrice();
        return true;
    }

    public boolean cancelRequest(Product prod) {
        if(inventory == null || prod == null) return false;
        inventory.add(prod);
        capacity++;
        moneyCollected -= prod.getPrice();
        return true;
    }

    public void refill(List<Product> refillProd) {
        //add to inventory
        //decrease the capacity
        if(capacity - refillProd.size() > 0) {
            inventory.addAll(refillProd);
            capacity -= refillProd.size();
        } else {
            System.out.println("Unable to refill products. Products quantity more than capacity.");
            throw new CapacityMaxedOutException("Unable to refill products. Products quantity more than capacity.");
        }
    }

    public void machineReset(){
        capacity = 0;
        moneyCollected = 0d;
        inventory.clear();
    }
}
