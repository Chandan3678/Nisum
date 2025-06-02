package day2;


import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double grade;

    Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}

public class StudentManagement {

    static ArrayList<Student> students = new ArrayList<>();

    static void addStudent(int id, String name, double grade) {
        students.add(new Student(id, name, grade));
        System.out.println("Student added successfully!");
    }

    static void removeStudent(int id) {
        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                removed = true;
                System.out.println("Student removed successfully!");
                break;
            }
        }
        if (!removed) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    static void searchStudent(int id) {
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student Found: ID=" + s.id + ", Name=" + s.name + ", Grade=" + s.grade);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.println("List of Students:");
            for (Student s : students) {
                System.out.println("ID=" + s.id + ", Name=" + s.name + ", Grade=" + s.grade);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student\n2. Remove Student\n3. Search Student\n4. Display All Students\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade = sc.nextDouble();
                    addStudent(id, name, grade);
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    int removeId = sc.nextInt();
                    removeStudent(removeId);
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    searchStudent(searchId);
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
