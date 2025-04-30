package advanced.lv6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    //속성
    private Map<MenuItem, Integer> cartItems;
    private int totalQuantity;
    private int totalPrice;

    //생성자
    public Cart() {
        this.cartItems = new HashMap<>();
        this.totalQuantity = 0;
        this.totalPrice = 0;
    }

    //기능
    public void addItem(MenuItem menuItem) {
        cartItems.put(menuItem, cartItems.getOrDefault(menuItem, 0) + 1);
        this.totalQuantity++;
        this.totalPrice += menuItem.getPrice();
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

    public int getCartSize() {
        return cartItems.size();
    }

    public Set<MenuItem> getCartItems() {
        return cartItems.keySet();
    }

    public int getItemQuantity(MenuItem menuItem) {
        return cartItems.get(menuItem);
    }

    public void clearCart() {
        cartItems.clear();
        this.totalQuantity= 0;
        this.totalPrice = 0;
    }
}
