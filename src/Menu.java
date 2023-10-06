import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, Integer> itemList;
    private double billBeforeTip;
    private int numPeople;
    private int tipPercent;
    public Menu(int numPeople, int tipPercent) {
        this.itemList = new HashMap<>();
        this.billBeforeTip = 0.0;
        this.numPeople = numPeople;
        this.tipPercent = tipPercent;
    }

    public double getBillBeforeTip() {
        return billBeforeTip;
    }

    public int getTipPercent() {
        return tipPercent;
    }

    public double getTipAmount() {
        return billBeforeTip * tipPercent / 100;
    }

    public double getBill() {
        return getTipAmount() + billBeforeTip;
    }
    
    public Map<String, Integer> getItemList() {
        return itemList;
    }

    public double getCostPerPersonNoTip() {
        return billBeforeTip / numPeople;
    }

    public double getPerPersonTip() {
        return getTipAmount() / numPeople;
    }

    public double getCostPerPerson() {
        return getCostPerPersonNoTip() + getPerPersonTip();
    }

    public void addItem(String name, double cost, int count) {
        billBeforeTip += cost * count;  // add cost to total bill
        /* https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction-
        checks if item is in hashmap
        then adds numItem to current value or creates key and sets value to numItem
        */
        itemList.merge(name, count, Integer::sum);
    }




}
