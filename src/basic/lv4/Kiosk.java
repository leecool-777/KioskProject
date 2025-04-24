package basic.lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus;

    public Kiosk() {
        this.menus = new ArrayList<>();
    }


    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
        }
        System.out.println("0. 종료");

        while (true) {

            int inputMenu = scanner.nextInt();

            if (inputMenu == 0) {
                break;
            } else if (inputMenu == 1) {
                showItemsOf(menus.get(0));
            } else if (inputMenu == 2) {
                showItemsOf((menus.get(1)));
            }

        }
    }

    public void showItemsOf(Menu menu) {
        System.out.println("[ " + menu.getCategoryName() + " MENU ]");
        menu.getMenuItems();

    }
}


