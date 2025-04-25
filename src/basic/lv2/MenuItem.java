package basic.lv2;

public class MenuItem {
    private String name;
    private double price;
    private String info;

    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    @Override
    public String toString() {
        return String.format("%-13s  | W %.1f | %s", name, price, info);
    }
}
