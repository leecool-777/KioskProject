package advanced.lv5;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //속성
    private List<MenuItem> orders;
    private int quantity;
    private double totalPrice;

    //생성자
    public Cart() {
        this.orders = new ArrayList<>();
        this.quantity = 0;
        this.totalPrice = 0;
    }

    //기능
    public void addItem(MenuItem item) {
        orders.add(item);
        totalPrice += item.getPrice();
        quantity++;
    }

    public boolean isOrderEmpty() {
        return orders.isEmpty();
    }

    public void viewCart() {
        System.out.println("\n[ ORDERS ]");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i+1) + ". " + orders.get(i));
        }
        System.out.println("\n[ TOTAL ]");
        System.out.println("W "+ totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void clearCart() {
        orders.clear();
        this.totalPrice = 0;
    }
}
