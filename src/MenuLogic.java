import java.util.HashMap;
import java.util.Map;
public class MenuLogic {
    private Map<String, Integer> allItems;
    private Menu currMenu;
    private int totalMenus;
    private double totalMenusCost;
    private double totalMenusTip;
    private double totalMenusBill;


    public MenuLogic() {
        allItems = new HashMap<>();
        currMenu = null;
    }

    private String parseHashMap(Map<String, Integer> hashMap) {
        String str = "";
        for (Map.Entry<String, Integer> pair: hashMap.entrySet()) {
            str += pair.getKey() + " x" + pair.getValue() + "\n";
        }
        return str;
    }

    public void createMenu(int numPeople, int tipPercent) {
        currMenu = new Menu(numPeople, tipPercent);
    }

    public Menu getMenu() {
        return currMenu;
    }

    public String getItemListString() {
        return parseHashMap(currMenu.getItemList());
    }
    public void removeMenu() {
        for (Map.Entry<String, Integer> pair: currMenu.getItemList().entrySet()) {
            allItems.merge(pair.getKey(), pair.getValue(), Integer::sum);
        }
        currMenu = null;
    }

    public String getAllItemListString() {
        return parseHashMap(allItems);
    }
}
