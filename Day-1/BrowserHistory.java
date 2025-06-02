package day2;



import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {

    static Stack<String> history = new Stack<>();

    static void visitSite(String url) {
        history.push(url);
        System.out.println("Visited: " + url);
    }

    static void goBack() {
        if (history.size() > 1) {
            history.pop();
            System.out.println("Went back to: " + history.peek());
        } else {
            System.out.println("No previous page to go back to.");
        }
    }

    static void currentPage() {
        if (!history.isEmpty()) {
            System.out.println("Current page: " + history.peek());
        } else {
            System.out.println("No pages visited yet.");
        }
    }

    static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available.");
        } else {
            System.out.println("Browser History:");
            for (String url : history) {
                System.out.println(url);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        String url;

        do {
            System.out.println("\n1. Visit Site\n2. Go Back\n3. Current Page\n4. Show History\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter URL to visit: ");
                    url = sc.nextLine();
                    visitSite(url);
                }
                case 2 -> goBack();
                case 3 -> currentPage();
                case 4 -> showHistory();
                case 5 -> System.out.println("Exiting browser history.");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
