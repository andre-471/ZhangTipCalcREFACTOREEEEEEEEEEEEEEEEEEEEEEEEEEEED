import java.util.Map;
import java.util.HashMap;

public class Menu {
    private Map<String, Integer> listOfItems;
    private double totalBillBeforeTip;
    private int numPeople;
    private int tipPercent;
    public Menu(int numPeople, int tipPercent) {
        this.listOfItems = new HashMap<>();
        this.totalBillBeforeTip = 0.0;
        this.numPeople = numPeople;
        this.tipPercent = tipPercent;
    }

    public double getTotalBillBeforeTip() {
        return totalBillBeforeTip;
    }

    public int getTipPercent() {
        return tipPercent;
    }

    public double getTipAmount() {
        return totalBillBeforeTip * tipPercent / 100;
    }

    // should i use the methods again? or store it to a variable so
    // i dont need to calculate it again
    public double getTotalBill() {
        return getTipAmount() + totalBillBeforeTip;
    }

    public double costPerPersonNoTip() {
        return totalBillBeforeTip / numPeople;
    }

    public double perPersonTip() {
        return getTipAmount() / numPeople;
    }

    public double costPerPerson() {
        return costPerPersonNoTip() + perPersonTip();
    }

    public void addItem(String name, double cost, int count) {
        totalBillBeforeTip += cost * count;  // add cost to total bill
        /* https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction-
        checks if item is in hashmap
        then adds numItem to current value or creates key and sets value to numItem
        */
        listOfItems.merge(name, count, Integer::sum);
    }




}
