import java.util.Scanner;


public class SpreadsheetMain {
	
	
	public static void main(String[] args) {

		Scanner readInput = new Scanner(System.in);
		Spreadsheet spreadsheet = new Spreadsheet(10, 26);
		spreadsheet.print();
		
		while (true) {
			String cellNum = readInput.next();
			String equalsSign = readInput.next();
			String cellValue = readInput.nextLine();
	
			spreadsheet.takeInput(cellNum, cellValue);
		}
			
	}

}
