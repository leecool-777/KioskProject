package advanced.lv5;

public class MenuItem {
    //속성
    private final String name;
    private final double price;
    private final String info;

    //생성자
    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    //기능

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return String.format("%-15s | W %.1f | %s",name,price,info);
    }
}
