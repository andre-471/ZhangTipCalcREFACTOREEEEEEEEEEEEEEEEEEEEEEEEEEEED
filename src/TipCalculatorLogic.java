import java.text.DecimalFormat;
import java.util.Scanner;
public class TipCalculatorLogic {
    private static final DecimalFormat df = new DecimalFormat("$0.00");
    private MenuManager menuManager;
    private Scanner scan;
    private Menu currMenu;

    public TipCalculatorLogic() {
        menuManager = new MenuManager();  // manages the menu (total stuff)
        scan = new Scanner(System.in);
        currMenu = null;  // current menu
    }

    private void printMenuInfo() {
        System.out.println("==========================================");
        System.out.println("Total bill before tip: " + df.format(currMenu.getBillBeforeTip()));
        System.out.println("Total percentage: " + currMenu.getTipPercent() + "%");
        System.out.println("Total tip: " + df.format(currMenu.getTipAmount()));
        System.out.println("Total bill with tip: " + df.format(currMenu.getBill()));
        System.out.println("Per person cost before tip: " + df.format(currMenu.getCostPerPersonNoTip()));
        System.out.println("Tip per person: " + df.format(currMenu.getPerPersonTip()));
        System.out.println("Total cost per person: " + df.format(currMenu.getCostPerPerson()));
        System.out.println("==========================================");
        System.out.println("==========================================");
        System.out.println("Items ordered: ");
        System.out.println(menuManager.getMenuItemMapString());
    }

    public void printTotalMenusInfo() {
        System.out.println("==========================================");
        System.out.println();
        System.out.println("Total menus calculated: " + menuManager.getTotalMenus());
        System.out.println("Total menus bill before tip: " + df.format(menuManager.getTotalMenusBillNoTip()));
        System.out.println("Total menus tip: " + df.format(menuManager.getTotalMenusTip()));
        System.out.println("Total menus bill with tip: " + df.format(menuManager.getTotalMenusBill()));
        System.out.println("==========================================");
        System.out.println("Total items ordered: ");
        System.out.println(menuManager.getAllItemMapString());
    }
    public void start() {
        do {
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
            currMenu = menuManager.createMenu(numPeople, tipPercent);
            // menuLogic.createMenu(numPeople, tipPercent);
            while (!"end".equalsIgnoreCase(itemName)) {  // if the user didn't just end the loop
                // more item info
                System.out.print("Enter a cost in dollars and cents: ");
                itemCost = scan.nextDouble();
                scan.nextLine();
                System.out.print("How many? ");
                numItem = scan.nextInt();
                scan.nextLine();

                currMenu.addItem(itemName, itemCost, numItem);

                // prompt to be checked by while loop expression
                System.out.println();
                System.out.print("Enter the item (\"end\" to end calculation): ");
                itemName = scan.nextLine();
            }

            printMenuInfo();
            menuManager.removeMenu(); // no more menu

            System.out.println("==========================================");
            System.out.print("Do you want to calculate another menu? (Y/N) ");
        } while ("Y".equalsIgnoreCase(scan.nextLine())); // repeat if user says (Y)es

        // display total
        printTotalMenusInfo();

        scan.close(); // close the scanner please
    }
}
