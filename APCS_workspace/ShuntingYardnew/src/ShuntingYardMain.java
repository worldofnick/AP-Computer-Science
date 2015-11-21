import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ShuntingYardMain {

	public static void main(String[] args) {
		
		String sampleInput = "44 + 44";
		Queue<Token> outputQueue = shuntingYard(sampleInput);
		System.out.println(calcReversedPolished(outputQueue));
	
	}

	private static Queue<Token> shuntingYard(String input) {
		String[] inputArray = input.split(" ");
		Token[] inputTokenized = new Token[inputArray.length];
		
		for (int i = 0; i < inputArray.length; i++) {
			inputTokenized[i] = new Token();
			inputTokenized[i].stringToToken(inputArray[i]);
		}
		
		Queue<Token> outputQueue = new LinkedList<Token>();
		Stack<Token> operatorStack = new Stack<Token>();
		
		int index = 0;
		while (index < inputTokenized.length) {
			
			
			if (inputTokenized[index].getTokenType() == Token.TokenType.Number) {
				outputQueue.add(inputTokenized[index]);
				
			} else if(inputTokenized[index].getTokenType() == Token.TokenType.LeftBrace) {
				operatorStack.push(inputTokenized[index]);
						
			} else if(inputTokenized[index].getTokenType() == Token.TokenType.RightBrace) {
				// Pops all operators to output queue until it finds the matching brace.
				// Then discards matching braces.
				while (operatorStack.peek().getTokenType() != Token.TokenType.LeftBrace) {
					outputQueue.add(operatorStack.pop());
				}
				operatorStack.pop();
				
			} else if(inputTokenized[index].getTokenType() == Token.TokenType.Operator) {
				
				// Adds the first operator, doesn't check for others.
				if (operatorStack.isEmpty()) {
					operatorStack.push(inputTokenized[index]);
				} else {
					
					Token o2 = operatorStack.peek();
					
					if (inputTokenized[index].getAssoc() == Token.Associtivity.Left && 
							inputTokenized[index].getPrecedence() == o2.getPrecedence() || 
							inputTokenized[index].getPrecedence() < o2.getPrecedence()) {
						
						outputQueue.add(o2);
						operatorStack.push(inputTokenized[index]);
					} else {
						operatorStack.push(inputTokenized[index]);
					}
				}
				
			} 
			
			index++;
		}
		// Adds the rest of the operators to the queue.
		while (!operatorStack.isEmpty()) {
			// This prints the correct symbol, but when popped doesn't work.
			//System.out.println(operatorStack.pop().getSymbol());
			outputQueue.add(operatorStack.pop());
		}
		
		return outputQueue;
	}
	
	private static double calcReversedPolished(Queue<Token> outputQueue) {
		Stack <Double> resultStack = new Stack <Double>();
		
		int index = 0;
		while (!outputQueue.isEmpty()) {
			
			if (outputQueue.peek().getTokenType() == Token.TokenType.Number) {
				resultStack.push(outputQueue.remove().getValue());
				
			} else if(outputQueue.peek().getTokenType() == Token.TokenType.Operator) {
				
				char operator = outputQueue.remove().getSymbol();
				double secondRemoved = resultStack.pop();
				double firstRemoved = resultStack.pop();
				
				
				switch (operator) {
				case '+':
					resultStack.push(firstRemoved + secondRemoved);
					break;
				case '-':
					resultStack.push(firstRemoved - secondRemoved);
					break;
				case '/':
					resultStack.push(firstRemoved / secondRemoved);
					break;
				case '*':
					resultStack.push(firstRemoved * secondRemoved);
					break;

				default:
					break;
				}
				
				if (resultStack.size() == 1 && index > 2) {
					return resultStack.pop();
				}
					
			}
		index++;
		}
		return 0;
				
	}
	
}

