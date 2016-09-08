import java.util.ArrayList;
import java.util.Scanner;

public class InventoryTracker {

    public static void main(String[] args) {
        ArrayList<InventoryTrackerItem> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            int i = 1;
            for (InventoryTrackerItem item : items) {

//             System.out.println(+i + ". " + "[" + item.quantity + "]" + " " + item.text + " " + item.category);
               System.out.printf("%s. [%s] %s %s\n",i, item.quantity, item.text, item.category);
                i++;
            }

            System.out.println("\n");
            System.out.println("1. Create inventory item");
            System.out.println("2. Remove inventory item");
            System.out.println("3. Update the quantity of inventory item\n");

            String option = scanner.nextLine();

            InventoryTrackerItem item = null;
            if (option.equals("1")) {
                System.out.println("Enter your item name:");
                String itemName = scanner.nextLine();

                item = new InventoryTrackerItem(itemName, 0, itemName);
//              System.out.println("How many " + itemName + " do we have?");
                System.out.printf("How many %s do we have?\n", itemName);
                Integer quantity = Integer.parseInt(scanner.nextLine());

                System.out.println("What category does this fit in?\n [Sporting Goods] [Housewares] " +
                        "[Mens Clothing] [Hardware] [Electronics]");
                String category = scanner.nextLine();

                createItem(items, scanner, itemName, quantity, category);

            } else if (option.equals("2")) {
                System.out.println("Enter the item number you would like to remove");
                int itemNumber = Integer.valueOf(scanner.nextLine());
                items.remove(itemNumber - 1);

            } else if (option.equals("3")) {
                System.out.println("Enter the item number you would like to update");
                int itemNumber = Integer.valueOf(scanner.nextLine());
                item = items.get(itemNumber - 1);

                System.out.println("Enter the updated quantity");
                int newQuantity = Integer.valueOf(scanner.nextLine());
                item.quantity = newQuantity;

            } else {
                System.out.println("Invalid option");

            }

        }

    }

        static void createItem(ArrayList<InventoryTrackerItem> items, Scanner scanner, String text, int quantity, String category) {
            boolean found = false;
            do {
                try {
                    found = checkCategory(category);
                } catch (Exception e) {
                    System.out.println("Invalid category.");
                    System.out.println("Please select a new category");
                    category = scanner.nextLine();
                }
            }
                while(!found);

                InventoryTrackerItem item = new InventoryTrackerItem(text, quantity, category);
                items.add(item);


        }
        static boolean checkCategory(String category) throws Exception {
            if(category.equalsIgnoreCase("Electronics") || category.equalsIgnoreCase("Hardware") ||
                    category.equalsIgnoreCase("Housewares") || category.equalsIgnoreCase("Mens Clothing")
                    || category.equalsIgnoreCase("Sporting Goods")){
                return true;
            }
            else{
                throw new Exception("Invalid Category");
            }
        }

}



