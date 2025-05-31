package day2;


import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String name;
    double price;
    int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class ShoppingCart {
    static ArrayList<Item> cart = new ArrayList<>();

    static void addItem(String name, double price, int quantity) {
        cart.add(new Item(name, price, quantity));
        System.out.println("Item added to cart.");
    }

    static void removeItem(String name) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).name.equalsIgnoreCase(name)) {
                cart.remove(i);
                removed = true;
                System.out.println("Item removed from cart.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Item not found in cart.");
        }
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Items in Cart:");
            for (Item item : cart) {
                System.out.println(item.name + " - ₹" + item.price + " x " + item.quantity);
            }
        }
    }

    static void calculateTotal() {
        double total = 0;
        for (Item item : cart) {
            total += item.price * item.quantity;
        }
        System.out.println("Total Price: ₹" + total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Item\n2. Remove Item\n3. View Cart\n4. Total Price\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    addItem(name, price, quantity);
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeName = sc.nextLine();
                    removeItem(removeName);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    calculateTotal();
                    break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
