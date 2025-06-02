package day2;



import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleStack {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        boolean ab = true;
        while (ab) {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number to push: ");
                    int num = sc.nextInt();
                    stack.push(num);
                    System.out.println(num + " pushed to stack.");
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty!");
                    } else {
                        int popped = stack.pop();
                        System.out.println("Popped: " + popped);
                    }
                    break;

                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty!");
                    } else {
                        int top = stack.peek();
                        System.out.println("Top element: " + top);
                    }
                    break;

                case 4:
                    ab = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}

