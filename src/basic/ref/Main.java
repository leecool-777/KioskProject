package basic.ref;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> burgers = new ArrayList<>();
        burgers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        List<MenuItem> beverages = new ArrayList<>();
        beverages.add(new MenuItem("Coke", 1.0, "콜라"));
        beverages.add(new MenuItem("Sprite", 1.0, "스프라이트"));
        beverages.add(new MenuItem("Americano", 2.0, "아메리카노"));

        List<MenuItem> desserts = new ArrayList<>();
        desserts.add(new MenuItem("French Fries", 2.0, "특제 소스로 양념된 감자튀김"));
        desserts.add(new MenuItem("Corn Salad", 1.5, "특제 드레싱을 버무린 콘샐러드"));

        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("BURGERS", burgers));
        menus.add(new Menu("BEVERAGES", beverages));
        menus.add(new Menu("DESSERTS", desserts));

        Kiosk kiosk = new Kiosk(menus, scanner);
        kiosk.start();
    }
}
