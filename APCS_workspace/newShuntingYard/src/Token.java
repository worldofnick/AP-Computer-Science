


public class Token {

	enum TokenType {
		Nothing, Number, Operator, LeftBrace, RightBrace
	};
	
	enum Associtivity {
		Left, Right
	}

	private TokenType tokenType = TokenType.Nothing;
	private double value;
	private char symbol;
	private Associtivity assoc = Associtivity.Left;
	private int precedence = 0;
	
	Token() {
		
	}
	
	public void stringToToken(String s) {
		
		for (int i = 0; i < s.length(); i++) {
			if (s.matches(".*\\d.*")) {
				tokenType = TokenType.Number;
				value = Double.parseDouble(s);
			} else if (s.equals("(")) {
				tokenType = TokenType.LeftBrace;
				precedence = -12;
			} else if (s.equals(")")) {
				tokenType = TokenType.RightBrace;
				precedence = -99;
			} else {

				switch (s) {
				case "+":
					tokenType = TokenType.Operator;
					symbol = '+';
					precedence = 10;
					//parameterCount = 2;
					break;
				case "-":
					tokenType = TokenType.Operator;
					symbol = '-';
					precedence = 10;
					//parameterCount = 2;
					break;
				case "*":
					tokenType = TokenType.Operator;
					symbol = '*';
					assoc = Associtivity.Left;
					precedence = 20;
					//parameterCount = 2;
					break;
				case "/":
					tokenType = TokenType.Operator;
					symbol = '/';
					assoc = Associtivity.Left;
					precedence = 20;
					//parameterCount = 2;

				}
			}
		}

	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getPrecedence() {
		return precedence;
	}

	public void setPrecedence(int precedence) {
		this.precedence = precedence;
	}

	public Associtivity getAssoc() {
		return assoc;
	}

	public void setAssoc(Associtivity assoc) {
		this.assoc = assoc;
	}
	
	
	
	
		
}
