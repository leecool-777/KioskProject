package advanced.lv5;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    private List<Menu> menus;
    private Order order;
    private Scanner scanner;

    //생성자
    public Kiosk(List<Menu> menus, Order order, Scanner scanner) {
        this.menus = menus;
        this.order = order;
        this.scanner = scanner;
    }

    //기능
    public void start() {
        while (true) {
            displayMainMenu();
            int inputMenu = scanner.nextInt();
            if (inputMenu == 0) {
                break;
            }
            if (order.isEmpty() && inputMenu > menus.size()) {
                System.out.println("잘못 입력하셨습니다.");
                continue;
            }
            Menu selectedMenu = menus.get(inputMenu - 1);
            displayMenuItem(selectedMenu);
            int inputItem = scanner.nextInt();

            //To do


        }
    }

    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료");
        if (!order.isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
        System.out.println("===============================================================");
    }

    private void displayMenuItem(Menu menu) {
        menu.displayMenuItem(menu);
    }
}
