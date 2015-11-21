import java.util.Scanner;

public class SpreadsheetMain {
	// Nick Porter
	public static void main(String[] args) {
				
		Scanner readInput = new Scanner(System.in);
		Spreadsheet spreadsheet = new Spreadsheet(4,4);
		spreadsheet.print();
		
		while (true) {
			System.out.print("> ");
			String cellNum = readInput.next();
			
			if (cellNum.equalsIgnoreCase("quit")) {
				
				System.out.println("Goodbye");
				break;
			} else if(cellNum.equalsIgnoreCase("help")) {
				
				spreadsheet.printHelp();
			}
			 
			String equalsSign = readInput.next();
			if (equalsSign.equalsIgnoreCase("formula")) {
				spreadsheet.printFormula(cellNum);
				continue;
			}
			String cellValue = readInput.nextLine();

	
			spreadsheet.assignValues(cellNum, cellValue.trim());
		}
		
		readInput.close();

	}

}

/*
 * Feature list:
 * Assign String and Numeric values.
 * Simple math such as c3 = 44.3 - 24.3
 * Cell to cell assignments. That update when the corresponding cell updates as well.
 * Order of operations math. c2 = a1 + 3 ( 44 / d1 ) Shunting Yard algorithm.
 * Use unlimited amount of operators and cells in an equation.
 * b1 = a1 + a2 + a3 + 393.3...
 * Cells are responsive.
 * Type <cellID> formula to see the formula of the cell.
*/





