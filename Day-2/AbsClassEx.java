abstract class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void introduce();
    public void displayInfo() {
        System.out.println("Person Name: " + name);
        System.out.println("Person Age: " + age);
    }
}
class Student extends Person {
    public Student(String name, int age) {
        super(name, age);  
    }

    public void introduce() {
        System.out.println(name + " says: Hi! I am a student.");
    }
}

public class AbsClassEx {
    public static void main(String[] args) {
       
        Student student = new Student("Chandan", 21);
        student.displayInfo(); 
        student.introduce();   
    }
}
