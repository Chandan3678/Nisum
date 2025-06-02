package day2;


import java.util.HashSet;
import java.util.Scanner;

public class EmailDuplicateRemover {

    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Enter email addresses one by one.");
        System.out.println("Type 'stop' to finish the entering of emails.\n");

        while (true) {
            System.out.print("Enter email: ");
            input = sc.nextLine();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            emails.add(input);
        }

        System.out.println("\nUnique Email Addresses:");
        for (String email : emails) {
            System.out.println(email);
        }

        sc.close();
    }
}
