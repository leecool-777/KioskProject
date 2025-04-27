package advanced.lv5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    private final List<Menu> menus;
    private final Cart cart;
    private final Scanner scanner;

    //생성자
    public Kiosk(List<Menu> menus, Cart cart, Scanner scanner) {
        this.menus = menus;
        this.cart = cart;
        this.scanner = scanner;
    }

    //기능
    //실행 흐름제어
    public void start() {
        while (true) {
            try {
                //메인 메뉴
                displayMainMenu();

                int userChoiceMenu = scanner.nextInt();

                if (userChoiceMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
                if (cart.isOrderEmpty() && userChoiceMenu > menus.size()) {
                    System.out.println("잘못 입력하셨습니다.");
                    continue;
                }
                //오더 메뉴
                if (userChoiceMenu == 4 || userChoiceMenu == 5) {
                    handleOrdersMenu(userChoiceMenu);
                    continue;
                }

                Menu selectedMenu = menus.get(userChoiceMenu - 1);

                //아이템 메뉴
                displayMenuItem(selectedMenu);

                int userChoiceItem = scanner.nextInt();
                MenuItem selectedItem = selectedMenu.getMenuItem(userChoiceItem - 1);

                if (userChoiceItem == 0) {
                    continue;
                }

                //장바구니 추가
                addToCart(userChoiceItem, selectedMenu, selectedItem);

            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("유효하지 않은 입력입니다. 다시 진행 해주세요");
                scanner.nextLine();
            }
        }
    }

    private void addToCart(int userChoiceItem, Menu selectedMenu, MenuItem selectedItem) {
        if (0 < userChoiceItem && userChoiceItem <= selectedMenu.getMenuSize()) {
            System.out.println("선택하신 상품: " + selectedItem);
        }
        System.out.println("\n" + selectedItem + "\n위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인              2. 취소");
        System.out.print("입력: ");
        int inputConfirm = scanner.nextInt();

        switch (inputConfirm) {
            case 1:
                cart.addItem(selectedItem);
                System.out.println(selectedItem.getName() + " 이(가) 장바구니에 추가되었습니다.");
                System.out.println("===============================================================");
            case 2:
                break;
            default:
                System.out.println("잘못입력하셨습니다");
                break;
        }
    }

    private void displayMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료");
        if (!cart.isOrderEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }
        System.out.println("===============================================================");
        System.out.print("입력: ");
    }

    private void displayMenuItem(Menu menu) {
        System.out.println("[ " + menu.getCategory() + " MENU ]");
        for (int i = 0; i < menu.getMenuSize(); i++) {
            System.out.println((i + 1) + ". " + menu.getMenuItem(i));
        }
        System.out.println("===============================================================");
        System.out.print("입력: ");
    }

    private void handleOrdersMenu(int selectMenu) {
        if (selectMenu == 4) {
            cart.viewCart();
            System.out.print("\n1. 주문              2. 메뉴판\n입력: ");
            int selectOrder = scanner.nextInt();
            if (selectOrder == 1) {
                System.out.println("주문이 완료되었습니다 ! 금액은 W " + cart.getTotalPrice() + " 입니다.");
                cart.clearCart();
            }
        } else if (selectMenu == 5) {
            cart.clearCart();
            System.out.println("장바구니를 비웠습니다 !");
        }
    }
}
