		public class OnlyDigitsCheck {
    			public static void main(String[] args) {
        					String input = "15A";
        					boolean onlyDigits = true;

        				for (char c : input.toCharArray()) {
            				if (!Character.isDigit(c)) {
                				onlyDigits = false;
                				break;
            				}
        				}

        			  System.out.println(onlyDigits ? "Only digits" : "Contains non-digits");
    			}
		}
