import java.util.Map;
import java.util.HashMap;

public class Menu {
    Map<String, Integer> listOfItems;
    double totalCost;
    int numPeople;
    int tipPercent;
    public Menu() {
        listOfItems = new HashMap<>();
        double totalCost = 0.0;
    }

    public void addItem(String name, double cost, int count) {
        totalCost += cost * count;  // add cost to totalCost
        /* https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#merge-K-V-java.util.function.BiFunction-
        checks if item is in hashmap
        then adds numItem to current value or creates key and sets value to numItem
        */
        listOfItems.merge(name, count, Integer::sum);
    }


}
