package advanced.lv6;

import java.util.List;

public class Menu {
    //속성
    private final String category;
    private final List<MenuItem> menuItemList;

    //생성자

    public Menu(String category, List<MenuItem> menuItemList) {
        this.category = category;
        this.menuItemList = menuItemList;
    }

    //기능

    public String getCategory() {
        return category;
    }

    public int getListSize() {
        return menuItemList.size();
    }

    public MenuItem getMenuItem(int i) {
        return menuItemList.get(i);
    }
}
