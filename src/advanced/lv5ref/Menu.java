package advanced.lv5ref;

import java.util.List;

public class Menu {

    private final String category;
    private final List<MenuItem> menuItemList;

    public Menu(String category, List<MenuItem> menuItemList) {
        this.category = category;
        this.menuItemList = menuItemList;
    }

    public String getCategory() {
        return category;
    }

    public MenuItem getMenuItem(int i) {
        return menuItemList.get(i);
    }

    public int getItemListSize() {
        return menuItemList.size();
    }
}
