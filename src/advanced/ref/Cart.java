package advanced.ref;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {

    private Map<MenuItem, Integer> cartItems;
    private int totalQuantity;
    private double totalPrice;

    public Cart() {
        this.cartItems = new HashMap<>();
        this.totalQuantity = 0;
        this.totalPrice = 0;
    }

    public void addItem(MenuItem menuItem) {
        cartItems.put(menuItem, cartItems.getOrDefault(menuItem, 0) + 1);
        totalQuantity++;
        totalPrice += menuItem.getPrice();
    }

    public Set<MenuItem> getCartItems() {
        return cartItems.keySet();
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

    public int getCartItemQuantity(MenuItem menuItem) {
        return cartItems.get(menuItem);
    }

    public void clearCart() {
        cartItems.clear();
        totalQuantity = 0;
        totalPrice = 0;
    }
}
