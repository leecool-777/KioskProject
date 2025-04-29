package advanced.ref;


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
    public void start() {
        int orderMenuNum = menus.size() + 1;
        int cancelOrderNum = menus.size() + 2;
        while (true) {
            displayMainMenu();
            try {
                int userMenuChoice = scanner.nextInt();
                if (userMenuChoice == 0) {
                    break;
                }
                if (!cart.isEmpty() && userMenuChoice == orderMenuNum || userMenuChoice == cancelOrderNum) {
                    handleOrderMenu(userMenuChoice);
                    continue;
                }
                Menu selectedMenu = menus.get(userMenuChoice - 1);

                if (0 < userMenuChoice && userMenuChoice <= menus.size()) {
                    displayMenuItem(selectedMenu);
                }

                MenuItem selectedItem = selectedMenu.getMenuItem(scanner.nextInt() - 1);

                System.out.println("선택한 메뉴: " + selectedItem);

                confirmAddToCart(selectedItem);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("유효하지 않은 입력입니다.\n");
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }
    private void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategory());
        }
        System.out.println("0. 종료");
        if (!cart.isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println((menus.size()+1) +". Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println((menus.size()+2) + ". Cancel       | 진행중인 주문을 취소합니다.");
        }
        printSeparator();
        System.out.print("입력: ");
    }

    private void displayMenuItem(Menu menu) {
        System.out.println("[ " + menu.getCategory() + " ]");
        for (int i = 0; i < menu.getItemListSize(); i++) {
            System.out.println((i + 1) + ". " + menu.getMenuItem(i));
        }
        System.out.println("0. 뒤로가기");
        printSeparator();
        System.out.print("입력: ");
    }

    private void handleOrderMenu(int userChoiceMenu) {
        if (userChoiceMenu == menus.size() + 1) {
            printOrderMenu();
            confirmOrder();
        } else if (userChoiceMenu == menus.size() + 2) {
            confirmClearCart();
        }
    }

    private void confirmClearCart() {
        System.out.println("\n장바구니를 비우시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        System.out.print("입력: ");
        switch (scanner.nextInt()) {
            case 1 -> {
                cart.clearCart();
                System.out.println("\n장바구니를 비웠습니다.\n");
                printSeparator();
            }
            case 2 -> System.out.println("\n메인메뉴로 돌아갑니다.\n");
            default -> System.out.println("\n잘못 입력하셨습니다. 다시 시도해주세요.\n");
        }
    }

    private void confirmOrder() {
        System.out.println("\n위와같이 주문하시겠습니까?\n1. 주문        2. 메뉴판");
        System.out.print("입력: ");
        switch (scanner.nextInt()) {
            case 1 -> {
                System.out.println("\n주문이 완료되었습니다. 결제금액은 W " + cart.getTotalPrice() + " 입니다.\n");
                printSeparator();
                cart.clearCart();
            }
            case 2 -> System.out.println("\n메인메뉴로 돌아갑니다.\n");
            default -> System.out.println("\n잘못 입력하셨습니다. 다시 시도해주세요.\n");
        }
    }

    private void printOrderMenu() {
        System.out.println("[ Orders ]");
        for (MenuItem cartItem : cart.getCartItems()) {
            System.out.println(cartItem + " * " + cart.getCartItemQuantity(cartItem));
        }
        System.out.println("\n[ Total ]");
        System.out.println("W " + cart.getTotalPrice());
    }

    private void confirmAddToCart(MenuItem selectedItem) {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인        2. 취소");
        System.out.print("입력: ");
        switch (scanner.nextInt()) {
            case 1:
                cart.addItem(selectedItem);
                System.out.println(selectedItem.getName() + "이(가) 장바구니에 추가되었습니다.\n");
                printSeparator();
                break;
            case 2:
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
    }

    private static void printSeparator() {
        System.out.println("=========================================================================");
    }
}
