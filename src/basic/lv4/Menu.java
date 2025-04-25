package basic.lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //속성
    private String categoryName;
    private List<MenuItem> menuItems;

    //생성자
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    //기능
    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public void showMenuItems() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i + 1);
            System.out.println(". " + menuItems.get(i));
        }
    }
    public String getCategoryName() {
        return categoryName;
    }

    public int menuSize() {
        return menuItems.size();
    }

    public MenuItem getMenuItem(int i) {
        return menuItems.get(i-1);
    }
}
