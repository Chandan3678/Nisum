
public class InterfaceEx {
    public static void main(String[] args) {
        Puppy myPuppy = new Puppy();
        myPuppy.eat();  
        myPuppy.bark(); 
    }
}

interface Animal {
    void eat();
}
interface Dog extends Animal {
    void bark();
}
class Puppy implements Dog {
    public void eat() {
        System.out.println("Puppy eats dog food.");
    }

    public void bark() {
        System.out.println("Puppy barks softly.");
    }
}
