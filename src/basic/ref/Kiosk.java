package basic.ref;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    private List<Menu> menus;
    private Scanner scanner;

    //생성자
    public Kiosk(List<Menu> menus, Scanner scanner) {
        this.menus = menus;
        this.scanner = scanner;
    }

    //기능
    public void start() {
        while (true) {
            try {
                displayMainMenu();

                int inputMenuNum = scanner.nextInt();
                if (inputMenuNum == 0) {
                    break;
                }
                Menu selectedMenu = menus.get(inputMenuNum - 1);

                displayMenuItems(selectedMenu);
                int inputItemNum = scanner.nextInt();
                if (inputItemNum == 0) {
                    continue;
                }
                MenuItem selectedItem = selectedMenu.getMenuItem(inputItemNum - 1);

                System.out.println("===============================================================================");
                System.out.println("주문되었습니다: " + selectedItem.getName());
                System.out.println("===============================================================================");

            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("유효하지 않은 입력입니다.");
                scanner.nextLine();
            }
        }
    }

    //메뉴 카테고리
    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료");
        System.out.println("===============================================================================");
        System.out.print("메뉴를 선택 해 주세요: ");
    }

    //메뉴 아이템
    private void displayMenuItems(Menu menu) {
        System.out.println("===============================================================================");
        System.out.println("[ " + menu.getCategory() + " ]");
        for (int i = 0; i < menu.getMenuSize(); i++) {
            System.out.println((i + 1) + ". " + menu.getMenuItem(i));
        }
        System.out.println("0. 뒤로가기");
        System.out.println("===============================================================================");
        System.out.print("상품을 선택 해 주세요: ");
    }
}

