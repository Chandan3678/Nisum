class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String toString() {
        return name + " (" + age + " years old)";
    }


    public boolean equals(Object obj) {
        Person other = (Person) obj;
        return this.name.equals(other.name) && this.age == other.age;
    }
}

public class SimpleObj2 {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 22);
        Person p2 = new Person("Alice", 22);

       
        System.out.println("p1: " + p1); 
        
        System.out.println("p1 equals p2? " + p1.equals(p2)); 

        System.out.println("Class of p1: " + p1.getClass().getName()); 
    }
}
/*
- toString()-This method returns a string representation .
- equals(Object obj)-This method checks if two objects are equal.
- getClass()-It simply tells us what class the object belongs to.
*/
