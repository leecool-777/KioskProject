package basic.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<MenuItem> burgers = new ArrayList<>();

        burgers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            for (int i = 0; i < burgers.size(); i++) {
                System.out.print(i + 1);
                System.out.println(". " + burgers.get(i));
                if (i == burgers.size() - 1) {
                    System.out.println("0. 종료");
                    System.out.println("===================================================================");
                }
            }
            System.out.print("번호를 입력하세요: ");
            int option = scanner.nextInt();
            if (option == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            } else if (option == 1) {
                System.out.println(burgers.get(0));
                break;
            } else if (option == 2) {
                System.out.println(burgers.get(1));
            } else if (option == 3) {
                System.out.println(burgers.get(2));
                break;
            } else if (option == 4) {
                System.out.println(burgers.get(3));
                break;
            }
        }
    }
}

