import java.util.HashMap;
import java.util.Map;
public class MenuManager {
    // instance variables
    private Map<String, Integer> allItems;
    private Menu currMenu;
    private int totalMenus;
    private double totalMenusBillNoTip;
    private double totalMenusTip;
    private double totalMenusBill;

    // constructor
    public MenuManager() {
        allItems = new HashMap<>();
        currMenu = null;
        totalMenus = 0;
        totalMenusBillNoTip = 0.0;
        totalMenusTip = 0.0;
        totalMenusBill = 0.0;

    }

    // private methods
    private String parseHashMap(Map<String, Integer> hashMap) {
        String str = "";
        for (Map.Entry<String, Integer> pair: hashMap.entrySet()) {
            str += pair.getKey() + " x" + pair.getValue() + "\n";
        }
        return str;
    }

    // getter(ish) methods
    public String getMenuItemMapString() {
        return parseHashMap(currMenu.getitemMap());
    }

    public String getAllItemMapString() {
        return parseHashMap(allItems);
    }

    public int getTotalMenus() {
        return totalMenus;
    }

    public double getTotalMenusBillNoTip() {
        return totalMenusBillNoTip;
    }

    public double getTotalMenusTip() {
        return totalMenusTip;
    }

    public double getTotalMenusBill() {
        return totalMenusBill;
    }

    // menu adder and remover
    public Menu createMenu(int numPeople, int tipPercent) {
        totalMenus += 1;
        currMenu = new Menu(numPeople, tipPercent);
        return currMenu;
    }

    public void removeMenu() {
        for (Map.Entry<String, Integer> pair: currMenu.getitemMap().entrySet()) {
            allItems.merge(pair.getKey(), pair.getValue(), Integer::sum);
        }
        totalMenusBillNoTip += currMenu.getBillBeforeTip();
        totalMenusTip += currMenu.getTipAmount();
        totalMenusBill += currMenu.getBill();
        currMenu = null;
    }
}
