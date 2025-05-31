		// this file should be in package1 which is a folder basically
		package package1;

		public class HelloWorld {
    			public void hello() {
        				System.out.println("Hello from package1!");
    			}
		}
		
		———————————————————————————-
		// this file in package 2 that means in another folder

		package package2;		
		import package1.HelloWorld;

		public class Test {
    			public static void main(String[] args) {
        				HelloWorld obj = new HelloWorld();
        				obj.hello();   		 	
			}
		}
