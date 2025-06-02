 //ii) Prevents Inheritance: Enforce strict control of logic. It cannot be extended which helps in improving security and stability.
			final class NoExtend {
    				public void show() {
        					System.out.println("This class cannot be extended.");
   				}
			}
		  //iii) Prevents Overriding - 

			class Parent {
		    		public final void display() {
				   System.out.println("This is a final method in Parent class.");
    				}
			}

			class Child extends Parent {
     			 /*
    				public void display() {
        					System.out.println("Trying to override in Child class.");
    				}
   			 */
			} // if we comment out then we will get compile error

			public class FinalMethodExample {
    				public static void main(String[] args) {
        					Child c = new Child();
        					c.display();
		}
			}

		
		//iv) Performance Benefit (JVM Optimization): JVM can inline static/final calls.
