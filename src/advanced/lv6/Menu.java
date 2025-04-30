package advanced.lv6;

import java.util.List;

public class Menu {
    //속성
    private String category;
    private List<MenuItem> menuItemList;

    //생성자

    public Menu(String category, List<MenuItem> menuItemList) {
        this.category = category;
        this.menuItemList = menuItemList;
    }

    //기능

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList.stream().toList();
    }
}
