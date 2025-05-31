

public class FuctClass {
    public static void main(String[] args) {
        Greeting greet = new MyGreeting();
        greet.sayHello("Avinash");
        greet.sayHello("Rath");
    }
}

interface Greeting {
    void sayHello(String name);
}
class MyGreeting implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
