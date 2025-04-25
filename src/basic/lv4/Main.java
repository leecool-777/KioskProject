package basic.lv4;


public class Main {

    public static void main(String[] args) {
        Menu burgerMenu = new Menu("BURGERS");
        burgerMenu.addItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addItem(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu beverageMenu = new Menu("BEVERAGES");
        beverageMenu.addItem(new MenuItem("Coke", 1.0, "콜라"));
        beverageMenu.addItem(new MenuItem("Sprite", 1.0, "스프라이트"));

        Menu desserts = new Menu("DESSERTS");
        desserts.addItem(new MenuItem("Potato", 2.0, "감자튀김"));
        desserts.addItem(new MenuItem("Salad", 1.0, "샐러드"));


        Kiosk kiosk = new Kiosk();
        kiosk.addMenu(burgerMenu);
        kiosk.addMenu(beverageMenu);
        kiosk.addMenu(desserts);


        kiosk.start();
    }
}
