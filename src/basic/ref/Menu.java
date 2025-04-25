package basic.ref;

import java.util.List;

public class Menu {
    //속성
    private String category;
    private List<MenuItem> menuItems;

    //생성자
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    //기능
    public String getCategory() {
        return category;
    }

    public int getMenuSize() {
        return menuItems.size();
    }

    public MenuItem getMenuItem(int index) {
        return menuItems.get(index);
    }
}
