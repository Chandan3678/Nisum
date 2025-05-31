	class A {
		    void show() {
		        System.out.println("Show method from class A");
		    }

 	}

		class B extends A {
		    @Override
		    void show() {
		        System.out.println("Show method from class B");
		    }
		}

		public class OverridingExample {
		    public static void main(String[] args) {
		        A obj;        
		        obj = new A();
		        obj.show();  
		        obj = new B();
		        obj.show();    
		   }
		}
	
