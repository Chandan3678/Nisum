package day2;


import java.util.*;

public class UniqueSortedElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> uniqueNumbers = new TreeSet<>();

        System.out.println("Enter numbers (type -1 to stop):");

        while (true) {
            int num = sc.nextInt();
            if (num == -1) break;
            uniqueNumbers.add(num);
        }

        System.out.println("Sorted Unique Elements: " + uniqueNumbers);
        sc.close();
    }
}
