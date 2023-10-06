import java.text.DecimalFormat;
import java.util.Scanner;
public class TipCalculatorLogic {
    private static final DecimalFormat df = new DecimalFormat("$0.00");
    private MenuLogic menuLogic;
    private Scanner scan;
    public TipCalculatorLogic() {
        menuLogic = new MenuLogic();
        scan = new Scanner(System.in);
    }

    public void printMenuInfo() {
        System.out.println("==========================================");
        System.out.println("Total bill before tip: " + df.format(menuLogic.getMenu().getBillBeforeTip()));
        System.out.println("Total percentage: " + menuLogic.getMenu().getTipPercent() + "%");
        System.out.println("Total tip: " + df.format(menuLogic.getMenu().getTipAmount()));
        System.out.println("Total bill with tip: " + df.format(menuLogic.getMenu().getBill()));
        System.out.println("Per person cost before tip: " + df.format(menuLogic.getMenu().getCostPerPersonNoTip()));
        System.out.println("Tip per person: " + df.format(menuLogic.getMenu().getPerPersonTip()));
        System.out.println("Total cost per person: " + df.format(menuLogic.getMenu().getCostPerPerson()));
        System.out.println("==========================================");
        System.out.println(menuLogic.getItemListString());
    }
    public void start() {
        // variables
        // loop for multiple calculation support
        do {
            // more variables
            // prompts user for info and stores it
            System.out.print("How many people are in your group: ");
            int numPeople = scan.nextInt();
            scan.nextLine();

            System.out.print("What's the tip percentage? (0-100): ");
            int tipPercent = scan.nextInt();
            scan.nextLine();

            // start of asking for item loop
            System.out.println();
            System.out.print("Enter the item (\"end\" to end calculation): ");
            String itemName = scan.nextLine();

            double itemCost;
            int numItem;
            menuLogic.createMenu(numPeople, tipPercent);
            while (!"end".equalsIgnoreCase(aItem)) {  // if the user didn't just end the loop
                // more item info
                System.out.print("Enter a cost in dollars and cents: ");
                itemCost = scan.nextDouble();
                scan.nextLine();
                System.out.print("How many? ");
                numItem = scan.nextInt();
                scan.nextLine();

                menuLogic.getMenu().addItem(itemName, itemCost, numItem);

                // prompt to be checked by while loop expression
                System.out.println();
                System.out.print("Enter the item (\"end\" to end calculation): ");
                itemName = scan.nextLine();
            }

            // cost is cost of food w/o tip
            // bill is cost + tip

            // just printing out info for user
            System.out.println("==========================================");
            System.out.println("Total bill before tip: " + df.format(totalCost));
            System.out.println("Total percentage: " + tipPercent + "%");
            System.out.println("Total tip: " + df.format(tipAmount));
            System.out.println("Total bill with tip: " + df.format(totalBill));
            System.out.println("Per person cost before tip: " + df.format(costPerPerson));
            System.out.println("Tip per person: " + df.format(tipPerPerson));
            System.out.println("Total cost per person: " + df.format(billPerPerson));
            System.out.println("==========================================");
            System.out.println("Items ordered: ");
            // https://stackoverflow.com/questions/43015098/how-to-iterate-through-a-map-in-java
            // I mean you didn't say it had to based on input order (prints each item)
            System.out.println();


            System.out.println("==========================================");
            System.out.print("Do you want to calculate another menu? (Y/N) ");
        } while ("Y".equalsIgnoreCase(scan.nextLine())); // repeat if user says (Y)es

        // display total
        System.out.println("==========================================");
        System.out.println();
        System.out.println("Total menus calculated: " + totalMenus);
        System.out.println("Total menus cost: " + df.format(totalMenusCost));
        System.out.println("Total menus tip: " + df.format(totalMenusTip));
        System.out.println("Total bills with tip: " + df.format(totalMenusBill));
        // display total items
        System.out.println("==========================================");
        System.out.println("Total items ordered: ");
        for (Map.Entry<String, Integer> pair: totalItems.entrySet()) {
            System.out.println(pair.getKey() + " x" + pair.getValue());
        }

        scan.close(); // close the scanner please
    }
}
