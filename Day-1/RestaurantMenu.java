package day2;


import java.util.*;

class MenuItem {
    String name;
    String description;
    double price;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description + ", Price: $" + price;
    }
}

public class RestaurantMenu {
    private static LinkedHashMap<String, HashMap<String, MenuItem>> menu = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // Sample data
        addMenuItem("Appetizers", new MenuItem("Spring Rolls", "Crispy rolls with vegetables", 5.99));
        addMenuItem("Appetizers", new MenuItem("Garlic Bread", "Toasted bread with garlic butter", 3.99));
        addMenuItem("Main Course", new MenuItem("Grilled Chicken", "Chicken grilled to perfection", 12.99));
        addMenuItem("Main Course", new MenuItem("Pasta", "Creamy pasta with mushrooms", 10.99));
        addMenuItem("Desserts", new MenuItem("Chocolate Cake", "Rich chocolate cake with icing", 6.99));

        while (running) {
            System.out.println("\n--- Restaurant Menu System ---");
            System.out.println("1. View Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Remove Menu Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayMenu();
                    break;

                case 2:
                    System.out.print("Enter category (e.g., Appetizers, Main Course): ");
                    String category = sc.nextLine();
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter item description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter item price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    addMenuItem(category, new MenuItem(name, desc, price));
                    System.out.println("Item added successfully.");
                    break;

                case 3:
                    System.out.print("Enter category: ");
                    String updateCat = sc.nextLine();
                    System.out.print("Enter item name to update: ");
                    String updateName = sc.nextLine();
                    System.out.print("Enter new description: ");
                    String newDesc = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();
                    updateMenuItem(updateCat, updateName, new MenuItem(updateName, newDesc, newPrice));
                    System.out.println("Item updated successfully.");
                    break;

                case 4:
                    System.out.print("Enter category: ");
                    String removeCat = sc.nextLine();
                    System.out.print("Enter item name to remove: ");
                    String removeName = sc.nextLine();
                    removeMenuItem(removeCat, removeName);
                    System.out.println("Item removed successfully.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Restaurant Menu. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }

    public static void addMenuItem(String category, MenuItem item) {
        menu.putIfAbsent(category, new HashMap<>());
        menu.get(category).put(item.name, item);
    }

    public static void removeMenuItem(String category, String itemName) {
        if (menu.containsKey(category)) {
            menu.get(category).remove(itemName);
        }
    }

    public static void updateMenuItem(String category, String itemName, MenuItem newItem) {
        if (menu.containsKey(category) && menu.get(category).containsKey(itemName)) {
            menu.get(category).put(itemName, newItem);
        }
    }

    public static void displayMenu() {
        if (menu.isEmpty()) {
            System.out.println("Menu is empty.");
        } else {
            for (Map.Entry<String, HashMap<String, MenuItem>> entry : menu.entrySet()) {
                System.out.println("\n" + entry.getKey() + ":");
                for (MenuItem item : entry.getValue().values()) {
                    System.out.println(item);
                }
            }
        }
    }
}