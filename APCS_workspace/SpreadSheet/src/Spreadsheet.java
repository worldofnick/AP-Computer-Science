/*
 * Main method constructs spread sheet with 4 rows and columns.
 * Then calls the print method.
 */

public class Spreadsheet {
	// Nick Porter
	private Cell[][] rowsAndColumns;
	private int numberOfColumns;
	private int numberOfRows;
	
	Spreadsheet(int numOfRows, int numOfColumns) {
		rowsAndColumns = new Cell[numOfRows][numOfColumns];
		setnumberOfRows(numOfRows);
		setnumberOfColumns(numOfColumns);
		
		for (int column = 0; column < numOfRows; column++) {	
			for (int row = 0; row < numOfColumns; row++) {
				// Initializes all cells to an empty state.
				rowsAndColumns[column][row] = new Cell();
			}
		}
		
		
		// [rowNum][colNum]
		
	}
	
	public void print() {
		// Add one to numberOfColumns to account for the header/number rows and columns.
		// *START HEADER*
		printDashes();
		System.out.print("|            |");
		for (int i = 0; i < numberOfColumns; i++) {
			// Add 65 to get the int cast to a char
			System.out.printf("%12c|", (char) i + 65);
		}
		
		for (int i = 0; i < numberOfRows; i++) {
			System.out.println();
			printDashes();
			System.out.printf("|%12d|", i + 1);
			// *END HEADER*
			for (int j = 0; j < numberOfColumns; j++) {
				System.out.printf("%12s|", rowsAndColumns[i][j]);
			}
			
		}
		
		System.out.println();
		printDashes();
		
	}

	private void printDashes() {
		System.out.print("-");
		for (int i = 0; i < numberOfColumns + 1; i++) {
			System.out.print("-------------");
		}
		System.out.println();
	}
	
	public void takeInput(String cell, String cellValue) {
		cell = cell.toLowerCase();
		char cellLetter = cell.charAt(0);
		int rowNumber = Integer.parseInt(cell.substring(1)) - 1;
		int letterIndex = cellLetter - '0' - 49;
		
		// Checks if the user entered something like a6 = b4.
		// First test ensures that the first char in the string is a letter.
		// Second test ensures that the remaining chars are digits.
		if (cellValue.substring(0, 1).matches("[a-zA-Z]") 
				&& cellValue.substring(1).matches("\\d+")) {
			
			char cellLetterAssign = cellValue.charAt(0);
			int letterIndexAssign = cellLetterAssign - '0' - 49;
			int rowNumberAssign = Integer.parseInt(cellValue.substring(1)) - 1;
			
			rowsAndColumns[rowNumber][letterIndex] = rowsAndColumns[rowNumberAssign][letterIndexAssign];
			
		} else {
			// Checks if the value is numeric or string.
			if (cellValue.matches("\\d+")) {
				rowsAndColumns[rowNumber][letterIndex] = new NumericCell(cellValue);
			} else {
				rowsAndColumns[rowNumber][letterIndex] = new StringCell(cellValue);
			}
		}
		
		print();
		
	}
	
	public int getnumberOfColumns() {
		return numberOfColumns;
	}

	public void setnumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

	public int getnumberOfRows() {
		return numberOfRows;
	}

	public void setnumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	
}

/*
------------------------------------------------------------------
|            |           A|           B|           C|           D|
------------------------------------------------------------------
|           1|            |            |            |            |
------------------------------------------------------------------
|           2|       AP CS|            |            |            |
------------------------------------------------------------------
|           3|            |            |            |            |
------------------------------------------------------------------
|           4|            |            |            |     -123.45|
------------------------------------------------------------------
*/

