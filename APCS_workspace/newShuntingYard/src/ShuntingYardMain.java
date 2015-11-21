import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ShuntingYardMain {

	public static void main(String[] args) {
		
		String sampleInput = "44 + 3.3 / 99 * ( 33 / 3 ) * 2";
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
		
			for (Token token : inputTokenized) {
				if (token.getTokenType() == Token.TokenType.Number) {
					outputQueue.add(token);

				} else if (token.getTokenType() == Token.TokenType.LeftBrace) {
					operatorStack.push(token);

				} else if (token.getTokenType() == Token.TokenType.RightBrace) {
					// Pops all operators to output queue until it finds the matching brace.
					// Then discards matching braces.
					while (operatorStack.peek().getTokenType() != Token.TokenType.LeftBrace) {
						outputQueue.add(operatorStack.pop());
					}
					operatorStack.pop();

				} else if (token.getTokenType() == Token.TokenType.Operator) {

					// Adds the first operator, doesn't check for others.
					if (operatorStack.isEmpty()) {
						operatorStack.push(token);
					} else {

						Token o2 = operatorStack.peek();

						if (token.getAssoc() == Token.Associtivity.Left
								&& token.getPrecedence() == o2.getPrecedence()
								|| token.getPrecedence() < o2.getPrecedence()) {
							
							outputQueue.add(operatorStack.pop());
							operatorStack.push(token);
						} else {
							operatorStack.push(token);
						}
					}

				}
			}
	
		// Adds the rest of the operators to the queue.
		while (!operatorStack.isEmpty()) {
			
			if (!(operatorStack.peek() == null)) {
				outputQueue.add(operatorStack.pop());
			}
		}
		
		return outputQueue;
	}
	
	private static double calcReversedPolished(Queue<Token> outputQueue) {
		Stack <Double> resultStack = new Stack <Double>();
		
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
				
				if (resultStack.size() == 1 && outputQueue.isEmpty()) {
					return resultStack.pop();
				}
					
			}
		}
		return 0;
				
	}
	
}

