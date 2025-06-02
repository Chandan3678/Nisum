package day2;
import java.util.*;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return "Name: " + name + ", Category: " + category + ", Price: $" + price;
    }
}

public class ProductSorter {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Face Wash", "Personal Care", 4.99));
        products.add(new Product("Toothpaste", "Personal Care", 2.99));
        products.add(new Product("Laptop", "Electronics", 899.99));
        products.add(new Product("Phone", "Electronics", 19.99));
        products.add(new Product("Aloo", "Grocery", 1.99));
        products.add(new Product("Onion", "Grocery", 0.99));

        products.sort(Comparator
                .comparing((Product p) -> p.category)
                .thenComparing(p -> p.price));

        System.out.println("Sorted Product List:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
