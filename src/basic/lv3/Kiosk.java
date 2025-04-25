package basic.lv3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    private List<MenuItem> menuItems;

    //생성자

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //기능
    public void start() {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i));
            }
            System.out.println("0. 종료");
            System.out.println("===================================================================");

            System.out.print("번호를 입력하세요: ");
            int option = scanner.nextInt();
            if (option == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            } else if (option == 1) {
                System.out.println(menuItems.get(0));
            } else if (option == 2) {
                System.out.println(menuItems.get(1));
            } else if (option == 3) {
                System.out.println(menuItems.get(2));
            } else if (option == 4) {
                System.out.println(menuItems.get(3));
            } else {
                System.out.println("유효하지 않은 입력입니다.");
            }
        }
    }
}
