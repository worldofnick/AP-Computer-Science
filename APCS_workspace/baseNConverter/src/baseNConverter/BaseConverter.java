package baseNConverter;

import java.util.ArrayList;
import java.util.Scanner;

// Nick Porter

public class BaseConverter {	

private String toBase;
private String fromBase;
private String number;
private String numberInBase10;
private String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
private String convertedNumber;

private ArrayList<String> inputTokens;

	
	public BaseConverter() {
		takeInput();
	}
	
	public void takeInput() {
		Scanner console = new Scanner(System.in);
		boolean quit = false;
		
		while (!quit) {
			System.out.print("Enter a number, a from base, and a to base: ");
			String input = console.nextLine();
			input = input.toUpperCase();
			if (input.equalsIgnoreCase("-1")) {
				System.out.println("Goodbye");
				System.exit(0); 
				break;
			}
			
			String[] tokenizedInput = input.split(" ");
			this.inputTokens = new ArrayList<String>();
			
			for(String s : tokenizedInput) {
				inputTokens.add(s);	
			}
			
			// Exactly three tokens
			if (inputTokens.size() > 3 || inputTokens.size() < 3) {
				System.out.println("Please enter exactly three tokens");
				takeInput();
			}
			
			// Successfully parsed input.
			this.number = this.inputTokens.get(0);
			this.fromBase = this.inputTokens.get(1);
			this.toBase = this.inputTokens.get(2);
			this.numberInBase10 = (convertToBaseTen(this.number, this.fromBase));
			if (this.toBase.equalsIgnoreCase("10")) {
				convertedNumber = this.numberInBase10;
			} else {
				convertedNumber = convertBase10ToAnyBase(numberInBase10, toBase);
			}
			
			System.out.println("   " + convertedNumber);
			clear();
			
		}
		
		//console.close();
		
	}
	
	public String convertToBaseTen(String num, String fromBase) {
		
		if (fromBase.equals("2") && !num.matches("[10]+")) {
			System.out.println("   Please enter a valid binary number.");
			/*
			 * Not sure if this is the right approach. I suppose the method stack could
			 * become very large if the user keeps inputting incorrect values. Maybe
			 * causing a STACK OVERFLOW :(.
			 */
			takeInput();
			return null;
		}
		
		int value = 0;
		if (fromBase.equals("10")) {
			return num;
		} else {
			int base = 0;
			try {
				base = Integer.parseInt(fromBase);
				if (base < 9 &&  !num.matches("\\d+")) {
					System.out.println("   Letters only appear in numbers in a base lower than 9.");
					takeInput();
					return null;
				}
			} catch (Exception e) {
				System.out.println("Try again");
				takeInput();
				return null;
			}
			
			if (base <= 0 ) {
				System.out.println("Please enter a base above 0");
				takeInput();
				return null;
			}
			
			int powerCounter = 0;
			for (int i = num.length() - 1; i >= 0; i--) {
				int numericalValue = this.digits.indexOf(num.charAt(i));
				value += (int) (numericalValue * Math.pow(base, powerCounter));
				
				powerCounter++;
			}
			
		}
		String valueString = Integer.toString(value);
		return valueString;
		
	}
	
	
	public String convertBase10ToAnyBase(String number, String toBase) {
		int num = 0;
		int base = 0;
		try {
			num = Integer.parseInt(number);
			base = Integer.parseInt(toBase);
		} catch (NumberFormatException e) {
			System.out.println("Please enter valid input");
			takeInput();
		}
		
		ArrayList<Integer> digit = new ArrayList<Integer>();
		int index = 0;
		while(num != 0) {
			int remainder = num % base;
			num = num / base;
			digit.add(index, remainder);
			index++;
		}
		
		String convertedNumber = "";
		for (int i = digit.size() - 1; i >= 0; i--) {
			int charAt = digit.get(i);
			char indexOfNum = digits.charAt(charAt);
			convertedNumber += indexOfNum;
			
		}
		
		return convertedNumber;
		
	}
	
	private void clear() {
		toBase = "";
		fromBase = "";
		number = "";
		numberInBase10 = "";
		convertedNumber = "";
		inputTokens.clear();
	}
	
}
