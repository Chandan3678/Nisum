package day2;

import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Dept: " + department + ", Salary: " + salary;
    }

    public int compareTo(Employee other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}

public class EmployeeRecords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Employee> employees = new TreeSet<>();

        employees.add(new Employee(1, "Chandan", "IT", 30000));
        employees.add(new Employee(2, "Yash", "Law", 70000));
        employees.add(new Employee(3, "Prathamesh", "MBBS", 155000));
        employees.add(new Employee(4, "Jibitesh", "MBBS", 88000));

        System.out.println("Employee Records (Sorted by Name):");
        displayEmployees(employees);

        while (true) {
            System.out.print("\nDo you want to add a new employee? (yes/no): ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                break;
            }

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Employee Department: ");
            String department = sc.nextLine();
            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employees.add(new Employee(id, name, department, salary));

            System.out.println("\nUpdated Employee Records (Sorted by Name):");
            displayEmployees(employees);
        }

        sc.close();
    }

    private static void displayEmployees(TreeSet<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
