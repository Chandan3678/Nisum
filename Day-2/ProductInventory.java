package day2;



import java.util.HashMap;
import java.util.Scanner;

public class ProductInventory {

    static HashMap<String, Integer> inventory = new HashMap<>();

    static void addProduct(String name, int quantity) {
        inventory.put(name, inventory.getOrDefault(name, 0) + quantity);
        System.out.println("Product added successfully!");
    }

    static void updateProduct(String name, int quantity) {
        if (inventory.containsKey(name)) {
            inventory.put(name, quantity);
            System.out.println("Product quantity updated!");
        } else {
            System.out.println("Product not found!");
        }
    }

    static void removeProduct(String name) {
        if (inventory.containsKey(name)) {
            inventory.remove(name);
            System.out.println("Product removed!");
        } else {
            System.out.println("Product not found!");
        }
    }

    static void checkStock(String name) {
        if (inventory.containsKey(name)) {
            System.out.println(name + " is in stock. Quantity: " + inventory.get(name));
        } else {
            System.out.println(name + " is not in stock.");
        }
    }

    static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Product Inventory:");
            for (String name : inventory.keySet()) {
                System.out.println(name + " - Quantity: " + inventory.get(name));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Remove Product\n4. Check Stock\n5. Display All\n6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            String name;
            int quantity;

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    name = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    addProduct(name, quantity);
                    break;

                case 2:
                    System.out.print("Enter product name to update: ");
                    name = sc.nextLine();
                    System.out.print("Enter new quantity: ");
                    quantity = sc.nextInt();
                    updateProduct(name, quantity);
                    break;

                case 3:
                    System.out.print("Enter product name to remove: ");
                    name = sc.nextLine();
                    removeProduct(name);
                    break;

                case 4:
                    System.out.print("Enter product name to check: ");
                    name = sc.nextLine();
                    checkStock(name);
                    break;

                case 5:
                    displayInventory();
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
