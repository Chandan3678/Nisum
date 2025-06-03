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

products.add(new Product("Moisturizer", "Personal Care", 7.49));
products.add(new Product("Mouthwash", "Personal Care", 3.49));
products.add(new Product("Smart TV", "Electronics", 1099.99));
products.add(new Product("Wireless Earbuds", "Electronics", 129.99));
products.add(new Product("Potatoes", "Grocery", 2.49));
products.add(new Product("Tomatoes", "Grocery", 1.29));


        products.sort(Comparator
                .comparing((Product p) -> p.category)
                .thenComparing(p -> p.price));

        System.out.println("Sorted Product List:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
