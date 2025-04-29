package advanced.lv5ref;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {

    private final Map<MenuItem, Integer> cartItems;
    private double totalPrice;

    public Cart() {
        this.cartItems = new HashMap<>();
        this.totalPrice = 0;
    }

    public void addItem(MenuItem menuItem) {
        cartItems.put(menuItem, cartItems.getOrDefault(menuItem, 0) + 1);
        totalPrice += menuItem.getPrice();
    }

    public Set<MenuItem> getCartItems() {
        return cartItems.keySet();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public int getCartItemQuantity(MenuItem menuItem) {
        return cartItems.get(menuItem);
    }

    public void clearCart() {
        cartItems.clear();
        totalPrice = 0;
    }
}
