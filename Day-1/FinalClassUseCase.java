			// 1. Final class - cannot be extended
final class Utility {

    // 2. Constant value - final + static
    public static final double PI = 3.14159;

    // 3. Static utility method
    public static int square(int x) {
        return x * x;
    }

    // 4. Final method (can't be overridden)
    public final void printInfo() {
        System.out.println("This is a final class.");
    }
}
public class FinalClassUseCase {
    public static void main(String[] args) {
        System.out.println("Value of PI: " + Utility.PI);
        int num = 2;
        System.out.println("Square of " + num + " is: " + Utility.square(num));
        Utility util = new Utility();
        util.printInfo();
    }
}
