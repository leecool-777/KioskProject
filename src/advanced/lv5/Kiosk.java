package advanced.lv5;

import java.util.InputMismatchException;
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
            try {


                //메인 메뉴
                displayMainMenu();
                int selectMenu = scanner.nextInt();
                if (selectMenu == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
                if (order.isEmpty() && selectMenu > menus.size()) {
                    System.out.println("잘못 입력하셨습니다.");
                    continue;
                }
                if (selectMenu == 4) {
                    order.getOrders();
                    System.out.print("\n1. 주문              2. 메뉴판\n입력: ");
                    int selectOrder = scanner.nextInt();
                    if (selectOrder == 1) {
                        System.out.println("주문이 완료되었습니다 ! 금액은 W " + order.getTotalPrice() + " 입니다.");
                        order.removeAllOrders();
                        continue;
                    } else if (selectOrder == 2) {
                        continue;
                    }
                } else if (selectMenu == 5) {
                    order.removeAllOrders();
                    System.out.println("장바구니를 비웠습니다 !");
                    continue;
                }
                Menu selectedMenu = menus.get(selectMenu - 1);

                //아이템 메뉴
                displayMenuItem(selectedMenu);

                int selectItem = scanner.nextInt();
                MenuItem selectedItem = selectedMenu.getMenuItem(selectItem - 1);

                if (selectItem == 0) {
                    continue;
                }

                if (0 < selectItem && selectItem <= selectedMenu.getMenuSize()) {
                    System.out.println("선택하신 상품: " + selectedItem);
                }
                System.out.println("\n" + selectedItem + "\n위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인              2. 취소");
                System.out.print("입력: ");
                int inputConfirm = scanner.nextInt();

                switch (inputConfirm) {
                    case 1:
                        order.addOrder(selectedItem);
                        System.out.println(selectedItem.getName() + " 이(가) 장바구니에 추가되었습니다.");
                        System.out.println("===============================================================");
                    case 2:
                        break;
                    default:
                        System.out.println("잘못입력하셨습니다");
                        break;
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("유효하지 않은 입력입니다. 다시 진행 해주세요");
                scanner.nextLine();
            }
            //To do
            /*
            장바구니 없을 때 미출력 4,5번 메서드 실행흐름 처리하기
             */


        }
    }

    private void displayMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
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
}

