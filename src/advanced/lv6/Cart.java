package advanced.lv6;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    //속성
    private Map<MenuItem, Integer> cartItems;
    private int totalQuantity;
    private double totalPrice;

    //생성자

    public Cart() {
        this.cartItems = new HashMap<>();
        this.totalQuantity = 0;
        this.totalPrice = 0;
    }

    //기능

    public Map<MenuItem, Integer> getCartItems() {
        return cartItems;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
