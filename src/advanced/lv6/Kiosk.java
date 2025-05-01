package advanced.lv6;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Kiosk {
    private static final String INPUT_NUMBER_MESSAGE = "입력: ";
    private static final String GO_TO_MAIN_MESSAGE = "메인 메뉴로 돌아갑니다.\n";
    private static final String WRONG_INPUT_MESSAGE = "잘 못 입력하셨습니다. 다시 시도 해 주세요.\n";
    private static final String PRINT_SEPARATOR = "=".repeat(70);

    //속성
    private final Cart cart;
    private final List<Menu> menus;
    private final Scanner scanner;

    //생성자
    public Kiosk(Cart cart, List<Menu> menus, Scanner scanner) {
        this.cart = cart;
        this.menus = menus;
        this.scanner = scanner;
    }

    //기능
    public void start() {
        while (true) {
            displayMainMenu();

            try {
                int userChoiceMenu;
                int userChoiceItem;

                //메뉴 선택
                userChoiceMenu = scanner.nextInt();
                if (userChoiceMenu == 0) {
                    break;
                }

                //장바구니가 비어있지 않았을 때 주문처리
                if (selectOrderMenu(userChoiceMenu)) {
                    handleOrderMenu(userChoiceMenu);
                    continue;
                }

                //선택된 메뉴의 아이템 선택
                Menu selectedMenu = menus.get(userChoiceMenu - 1);
                displayMenuItems(selectedMenu);

                userChoiceItem = scanner.nextInt();
                if (userChoiceItem == 0) {
                    continue;
                }
                //아이템 선택 후 장바구니 추가 여부
                if (selectItem(userChoiceItem, selectedMenu)) {

                    MenuItem selectedItem = selectedMenu.getMenuItem(userChoiceItem - 1);
                    System.out.println("\n선택하신 상품: " + selectedItem);
                    confirmAddItem(selectedItem);

                } else {
                    System.out.println(WRONG_INPUT_MESSAGE);
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("유효하지 않은 입력입니다. 다시 선택해주세요.");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        if (!cart.isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println((menus.size() + 1) + ". Orders");
            System.out.println((menus.size() + 2) + ". Cancel");
        }
        System.out.println(PRINT_SEPARATOR);
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    private void displayMenuItems(Menu menu) {
        System.out.println(PRINT_SEPARATOR);
        System.out.println("\n[ " + menu.getCategory() + " ]");
        for (int i = 0; i < menu.getListSize(); i++) {
            System.out.println((i + 1) + ". " + menu.getMenuItem(i));
        }
        System.out.println();
        System.out.println("0. 뒤로가기");
        System.out.println(PRINT_SEPARATOR);
        System.out.print(INPUT_NUMBER_MESSAGE);
    }


    //장바구니가 비어있고 입력값이 오더메뉴이거나 장바구니 제거 메뉴 일 때
    private boolean selectOrderMenu(int userChoiceMenu) {
        return !cart.isEmpty() && (userChoiceMenu == menus.size() + 1 || userChoiceMenu == menus.size() + 2);
    }

    private boolean selectItem(int userChoiceItem, Menu selectedMenu) {
        return 0 < userChoiceItem && userChoiceItem <= selectedMenu.getListSize();
    }

    //장바구니 추가 여부
    private void confirmAddItem(MenuItem selectedItem) {
        System.out.println("\n위 상품을 장바구니에 추가 하시겠습니까?");
        System.out.println("1. 확인           2. 취소");
        System.out.println(PRINT_SEPARATOR);
        System.out.print(INPUT_NUMBER_MESSAGE);

        int confirmInput = scanner.nextInt();
        switch (confirmInput) {
            case 1:
                cart.addItem(selectedItem);
                System.out.println(PRINT_SEPARATOR);
                System.out.println(selectedItem.getName() + " 이(가) 장바구니에 추가되었습니다 !");
                break;
            case 2:
                System.out.println(GO_TO_MAIN_MESSAGE);
                break;
            default:
                System.out.println(WRONG_INPUT_MESSAGE);
        }
    }

    //오더 메뉴 관리
    private void handleOrderMenu(int userMenuChoice) {
        switch (userMenuChoice) {
            case 4:
                confirmOrder();
                break;
            case 5:
                confirmClearOrder();
        }
    }

    //주문 확인 및 할인 유형에 따른 할인금액 적용 결제
    private void confirmOrder() {
        System.out.println("\n[ ORDERS ]");
        for (MenuItem cartItem : cart.getCartItems()) {
            System.out.println(cartItem + " * " + cart.getItemQuantity(cartItem));
        }
        System.out.println("\n\n[ TOTAL ]");
        System.out.println("  " + cart.getTotalPrice() + " W");
        System.out.println("\n주문하시겠습니까?\n1. 주문           2. 취소");
        System.out.println(PRINT_SEPARATOR);
        System.out.print(INPUT_NUMBER_MESSAGE);

        int confirmInput = scanner.nextInt();
        switch (confirmInput) {
            case 1:
                DiscountType discountType = getDiscountType();
                int discountPrice = cart.getTotalPrice() - getDiscountPrice(discountType, cart.getTotalPrice());
                System.out.println("\n주문이 완료되었습니다. 결제 금액은 " + discountPrice + " 원 입니다." );
                cart.clearCart();
                break;
            case 2:
                System.out.println(GO_TO_MAIN_MESSAGE);
                break;
            default:
                System.out.println(WRONG_INPUT_MESSAGE);
        }
    }

    //할인 유형 반환
    private DiscountType getDiscountType() {
        System.out.println("\n할인 정보를 입력해주세요");
        DiscountType[] discountTypeOptions = DiscountType.values();
        for (int i = 0; i < discountTypeOptions.length; i++) {
            DiscountType discountType = discountTypeOptions[i];
            System.out.printf("%d. %-7s : %2d %%\n", i + 1, discountType.getType(), discountType.getDiscountPercent());
        }
        System.out.println(PRINT_SEPARATOR);
        System.out.print(INPUT_NUMBER_MESSAGE);
        int inputType = scanner.nextInt();
        return discountTypeOptions[inputType - 1];
    }

    //할인 금액 반환
    private int getDiscountPrice(DiscountType discountType, int totalPrice) {
        return discountType.discount(discountType, totalPrice);
    }



    //장바구니 비우기
    private void confirmClearOrder() {
        System.out.println(PRINT_SEPARATOR);
        System.out.println("장바구니를 삭제하시겠습니까?\n1. 확인           2. 취소");
        System.out.println(PRINT_SEPARATOR);
        System.out.print(INPUT_NUMBER_MESSAGE);

        int confirmInput = scanner.nextInt();
        switch (confirmInput) {
            case 1:
                System.out.println("\n장바구니를 비웠습니다 !");
                cart.clearCart();
                break;
            case 2:
                System.out.println(GO_TO_MAIN_MESSAGE);
                break;
            default:
                System.out.println(WRONG_INPUT_MESSAGE);
        }
    }
}
