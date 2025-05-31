		public class RemoveExtraSpaces {
    			public static void main(String[] args) {
        				String s1 = "i      am        Avinash Rath";
        				String s = s1.replaceAll("\\s+", " ");

        				System.out.println(s);
    			}			
		}
