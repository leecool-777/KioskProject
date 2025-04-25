package advanced.lv5;

public class MenuItem {
    //속성
    private String name;
    private double price;
    private String info;

    //생성자
    public MenuItem(String name, double price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }

    //기능
    @Override
    public String toString() {
        return String.format("%-15s | W %1f | %s",name,price,info);
    }
}
