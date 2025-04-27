package advanced.lv5;

import java.util.List;

public class Menu {
    //속성
    private final String category;
    private final List<MenuItem> menuItems;

    //생성자

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    //기능
    public String getCategory() {
        return category;
    }

    public MenuItem getMenuItem(int index) {
        return menuItems.get(index);
    }

    public int getMenuSize() {
        return menuItems.size();
    }
}
