package advanced.lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<MenuItem> burgers = new ArrayList<>();
        List<MenuItem> beverages = new ArrayList<>();
        List<MenuItem> desserts = new ArrayList<>();

        burgers.add(new MenuItem("ShackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8900,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger",6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));

        beverages.add(new MenuItem("Coke", 1000, "시원한 콜라 500ml"));
        beverages.add(new MenuItem("Sprite", 1000, "시원한 사이다 500ml"));
        beverages.add(new MenuItem("Beer", 10000, "시원한 생맥주 1000cc"));
        beverages.add(new MenuItem("Ice Americano", 4000, "아이스 아메리카노"));

        desserts.add(new MenuItem("CornSalad", 1500, "특제 드레싱이 가미된 콘샐러드"));
        desserts.add(new MenuItem("French Fries", 2500, "특제 소스가 가미된 콘샐러드"));
        desserts.add(new MenuItem("Cheese Stick", 2000, "어디까지 늘어나는거니 치즈스틱"));
        desserts.add(new MenuItem("Nuggets", 2000, "맛있는 너겟"));

        List<Menu> categoryMenus = new ArrayList<>();
        categoryMenus.add(new Menu("BURGERS", burgers));
        categoryMenus.add(new Menu("BEVERAGES", beverages));
        categoryMenus.add(new Menu("DESSERTS", desserts));


        Cart cart = new Cart();

        Kiosk kiosk = new Kiosk(cart, categoryMenus, scanner);
        kiosk.start();
    }
}
