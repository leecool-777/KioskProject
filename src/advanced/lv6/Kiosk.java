package advanced.lv6;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    private static final String PRINT_SEPARATOR = "=".repeat(60);
    private static final String INPUT_NUMBER = "입력: ";

    private Cart cart;
    private List<Menu> menus;
    private Scanner scanner;

    //생성자

    public Kiosk(Cart cart, List<Menu> menus, Scanner scanner) {
        this.cart = cart;
        this.menus = menus;
        this.scanner = scanner;
    }

    //기능
    public void start() {
        while (true) {

            int userMenuChoice = displayMainMenu();
            if (userMenuChoice == 0) {
                break;
            }
        }
    }

    private int displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        if (!cart.isEmpty()) {
            displayOrderMenu();
        }
        System.out.println(PRINT_SEPARATOR);
        System.out.print(INPUT_NUMBER);
        return scanner.nextInt();
    }

    private void displayOrderMenu() {
        System.out.println("[ ORDER MENU ]");
        System.out.println((menus.size() + 1) + ". Orders");
        System.out.println((menus.size() + 2) + ". Cancel");
    }
}
