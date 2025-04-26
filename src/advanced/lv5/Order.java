package advanced.lv5;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //속성
    private List<MenuItem> orders;
    private int quantity;
    private double totalPrice;

    //생성자
    public Order() {
        this.orders = new ArrayList<>();
        this.quantity = 0;
        this.totalPrice = 0;
    }

    //기능
    public void addOrder(MenuItem item) {
        orders.add(item);
        totalPrice += item.getPrice();
        quantity++;
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public void getOrders() {
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

    public void removeAllOrders() {
        orders.clear();
        this.totalPrice = 0;
    }
}
