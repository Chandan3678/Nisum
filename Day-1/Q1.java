class A {


		    void show() {
		        System.out.println("Show method with no parameters");
		    }


		    void show(int a) {
		        System.out.println("Show method with int: " + a);
		    }
	}

	public class OverloadingExample {
		    public static void main(String[] args) {
		        A obj = new A();

		        obj.show();             
		        obj.show(10);             
     		}
	}


