package basic.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> burgers = new ArrayList<>();
        burgers.add("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        burgers.add("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        burgers.add("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        burgers.add("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");

            for (int i = 0; i < burgers.size(); i++) {
                System.out.println((i + 1) + ". " + burgers.get(i));
            }
            System.out.println("0. 종료");
            System.out.println("===================================================================");
            System.out.print("번호를 입력하세요: ");
            int option = scanner.nextInt();

            if (option == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }
            if (option > 0 && option <= burgers.size()) {
                System.out.println("선택한 상품: " + burgers.get(option - 1));
                System.out.println("===================================================================");
                return;
            }
        }
    }
}

