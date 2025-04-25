package basic.lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    private List<Menu> menus;
    Scanner scanner = new Scanner(System.in);

    //생성자
    public Kiosk() {
        this.menus = new ArrayList<>();
    }

    //기능
    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {

        while (true) {
            showMenu();

            System.out.print("메뉴를 선택해주세요: ");
            int inputMenu = scanner.nextInt();
            if (inputMenu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            Menu seletedMenu = menus.get(inputMenu - 1);

            showItemsOf(seletedMenu);
        }
    }

    private void showMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
        }
        System.out.println("0. 종료");
        System.out.println("===================================================================");
    }

    private void showItemsOf(Menu menu) {
        while (true) {
            System.out.println("[ " + menu.getCategoryName() + " MENU ]");
            menu.showMenuItems();
            System.out.println("0. 뒤로가기");
            System.out.println("===================================================================");
            System.out.print("상품을 선택해주세요: ");
            int choseItem = scanner.nextInt();
            if (choseItem == 0) {
                return;
            } else if (choseItem > 0 && choseItem <= menu.menuSize()) {
                System.out.println("선택한 상품: " + menu.getMenuItem(choseItem));
                System.out.println("===================================================================");
                return;
            }
        }
    }
}


