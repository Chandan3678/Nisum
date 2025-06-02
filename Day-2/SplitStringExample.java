		public class SplitStringExample {
   		 	public static void main(String[] args) {
        				String data = "iam,Avinash,Rath";
        				String[] names = data.split(",");
        				for (String name : names) {
            			System.out.println(name);
       			 	}
    			}
		}
