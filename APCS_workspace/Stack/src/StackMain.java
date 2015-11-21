
public class StackMain {
// Nick Porter
	public static void main(String[] args) {
		Stack stack = new Stack();
		String equation = "5 1 2 + 4 * + 3 -";
		String[] splitEquation = equation.split(" ");
		
		// Fill Stack
		for(String s : splitEquation) {
			stack.push(s);
		}

		// Math
		String result = postfix(stack);
		System.out.println(result);
		
	}
	
	private static String postfix(Stack inputStack) {
		// Reverse stack.
		Stack stack = new Stack();
		while(!inputStack.isEmpty()) {
			stack.push(inputStack.pop());
		}
		
		Stack output = new Stack();
		while (!stack.isEmpty()) {
			if (isNumeric(stack.peek())) {
				output.push(stack.pop());
				
			} else if(stack.peek().matches("[*-/+]")) {
				String operator = stack.pop();
				double first;
				double second;
				double result = 0;
				
				switch (operator) {
				
				case "+":
					first = Double.parseDouble(output.pop());
					second = Double.parseDouble(output.pop());
					result = second + first;
					break;
					
				case "-":
					first = Double.parseDouble(output.pop());
					second = Double.parseDouble(output.pop());
					result = second - first;
					break;
					
				case "/":
					first = Double.parseDouble(output.pop());
					second = Double.parseDouble(output.pop());
					result = second / first;
					break;
					
				case "*":
					first = Double.parseDouble(output.pop());
					second = Double.parseDouble(output.pop());
					result = second * first;
					break;

				default:
					break;
				}
				output.push("" + result);
			} else {
				System.out.println("Please ensure proper notation");
			}
		}
		
		return output.pop();
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    @SuppressWarnings("unused")
		double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}


}
