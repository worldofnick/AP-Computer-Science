import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Cell {
	// Nick Porter
	private String cellStringValue;
	// True == String, False == Numeric
	private boolean dataType;
	private double mathValue;
	private String formula;
	private int cellWidth = 12;
	private boolean cellInFormula;
	
	Cell() {
		setCellStringValue("");
		dataType = true;
	}
	
	
	public String getCellStringValue() {
		return cellStringValue;
	}
	
	public String getMathValue() {
		return Double.toString(mathValue);
	}

	public void setCellStringValue(String cellStringValue) {
		this.cellStringValue = cellStringValue;
		dataType = true;
	}
	
	public void setCellNumericValue(String cellStringValue) {
		boolean operators = checkForOperators(cellStringValue);
		this.cellStringValue = cellStringValue;
		
		if (operators) {
			Queue<Token> outputQueue = shuntingYard(cellStringValue);
			mathValue = calcReversedPolished(outputQueue);
			dataType = false;
		} else {
			this.mathValue = Double.parseDouble(cellStringValue);
		}

	}
	
	/*
	 * Converts the string into reversed polish notation.
	 */
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
	
	 //If any of the tokens in the string are an operator it returns true. 
	public boolean checkForOperators(String cellValue) {
		String[] operatorArray = {"+", "-", "/", "*"};
		String[] tokens = cellValue.split(" ");
		
		for (int i = 0; i < tokens.length; i++) {
			for (int j = 0; j < operatorArray.length; j++) {
				if (tokens[i].equals(operatorArray[j])) {
					return true;
				}
			}
		}
		return false;
			
	}
	// This method adds n amount of spaces to the left side of the string.
	public String padLeft(int n) {
		if (dataType) {
			return String.format("%1$" + n + "s", cellStringValue);
		} else {
			return String.format("%1$" + n + "s", Double.toString(round(mathValue, 2)));
		} 
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
	    return bd.doubleValue();
	}
	
	
	public int getCellWidth() {
		return cellWidth;
	}


	public void setCellWidth(int cellWidth) {
		this.cellWidth = cellWidth;
	}


	public String toString() {
		if (dataType) {
			return cellStringValue;
		} else {
			return Double.toString(round(mathValue, 2));
		}	
	}

	public String getFormula() {
		return formula;
	}


	public void setFormula(String formula) {
		this.formula = formula;
	}


	public boolean isCellInFormula() {
		return cellInFormula;
	}


	public void setCellInFormula(boolean cellInFormula) {
		this.cellInFormula = cellInFormula;
	}


	public boolean isDataType() {
		return dataType;
	}


	public void setDataType(boolean dataType) {
		this.dataType = dataType;
	}
		
}
