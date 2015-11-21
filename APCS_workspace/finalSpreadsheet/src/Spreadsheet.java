
public class Spreadsheet {
	// Nick Porter
		private Cell[][] rowsAndColumns;
		private int numberOfColumns;
		private int numberOfRows;
		private static int cellWidth = 12;

	Spreadsheet(int numOfRows, int numOfColumns) {
		rowsAndColumns = new Cell[numOfRows][numOfColumns];
		
		setNumberOfRows(numOfRows);
		setNumberOfColumns(numOfColumns);
		
		for (int column = 0; column < numOfRows; column++) {	
			for (int row = 0; row < numOfColumns; row++) {
				// Initializes all cells to an empty state.
				rowsAndColumns[column][row] = new Cell();
			}
		}
	}
	
	public void print() {
		// Add one to numberOfColumns to account for the header/number rows and columns.
		// *START HEADER*
		printDashes();
		System.out.print("|");
		System.out.print(String.format("%1$" + cellWidth + "s", "|"));
		for (int i = 0; i < numberOfColumns; i++) {
			// Add 65 to get the int cast to a char
			System.out.print(String.format("%1$" + cellWidth + "c|", (char) i + 65));
		}
		
		for (int i = 0; i < numberOfRows; i++) {
			System.out.println();
			printDashes();
			System.out.print("|");
			// Had to create a "new" width because I needed to minus 1, and I can't do it in the .format.
			int newCellWidth = cellWidth - 1;
			System.out.print(String.format("%1$" + newCellWidth + "d|", i + 1));
			// *END HEADER*
			for (int j = 0; j < numberOfColumns; j++) {
				
				if (rowsAndColumns[i][j].isCellInFormula()) {
					String updatedFormula = checkForCellAssign(rowsAndColumns[i][j].getFormula(), 
							!rowsAndColumns[i][j].isDataType(), rowsAndColumns[i][j]);
					
					if (rowsAndColumns[i][j].isDataType()) {
						rowsAndColumns[i][j].setCellStringValue(updatedFormula);
					} else {
						rowsAndColumns[i][j].setCellNumericValue(updatedFormula);
					}
				}
				System.out.printf("%s|", rowsAndColumns[i][j].padLeft(cellWidth));
			}
			
		}
		
		System.out.println();
		printDashes();
		 
	}

	private void printDashes() {
		String dashes = "-";
		for(int i = 0; i < cellWidth; i++) {
			dashes += "-";
		}
		
		for (int i = 0; i < numberOfColumns + 1; i++) {
			System.out.print(dashes);
		}
		System.out.println();
	}
	
	public void assignValues(String cell, String cellValue) {
		int letterIndex = getRowFromCellName(cell);
		int rowIndex = getColumnFromCellName(cell);
		boolean operators = rowsAndColumns[rowIndex][letterIndex].checkForOperators(cellValue);
		
		if (cellValue.substring(0, 1).matches("[a-zA-Z]+") &&
				cellValue.substring(1).matches("\\d+")) {
			int letterIndexAssign = getRowFromCellName(cellValue);
			int rowNumberIndexAssign = getColumnFromCellName(cellValue);
			rowsAndColumns[rowIndex][letterIndex] = rowsAndColumns[rowNumberIndexAssign][letterIndexAssign];
			rowsAndColumns[rowIndex][letterIndex].setDataType(true);
		}
		
		String formulaHolder = cellValue;
		cellValue = checkForCellAssign(cellValue, operators, rowsAndColumns[rowIndex][letterIndex]);
		
		 if (cellValue.matches(".*\\d.*") || operators) {
			
			rowsAndColumns[rowIndex][letterIndex].setCellNumericValue(cellValue);
			rowsAndColumns[rowIndex][letterIndex].setFormula(formulaHolder);
			
			if (rowsAndColumns[rowIndex][letterIndex].toString().length() > cellWidth) {
				cellWidth = rowsAndColumns[rowIndex][letterIndex].toString().length();
			}
			
		} else {
			
			rowsAndColumns[rowIndex][letterIndex].setCellStringValue(cellValue);
			rowsAndColumns[rowIndex][letterIndex].setFormula(cellValue);
			
			if (rowsAndColumns[rowIndex][letterIndex].toString().length() > cellWidth) {
				cellWidth = rowsAndColumns[rowIndex][letterIndex].toString().length();
			}
		} 
		
		print();
		
	}
	
	// Converts a char to int to get index in array.
	public int getRowFromCellName(String cell) {
			cell = cell.toLowerCase();
			char cellLetter = cell.charAt(0);
			int letterIndex = cellLetter - '0' - 49;
			return letterIndex;
	}
		// Finds the index of the row, to match up with the array.
	public int getColumnFromCellName(String cell) {
			int rowNumber = Integer.parseInt(cell.substring(1)) - 1;
			return rowNumber;
	}
	
	public void printHelp() {
		System.out.println("Example Input");
		System.out.println("b5 = 789.6");
		System.out.println("c7 = b5");
		System.out.println("c2 = 33.4 * ( c7 - b5 ) SPACE BETWEEN EACH CHARACTER");
		System.out.println("b4 = this is only a test");
		System.out.println("c8 = 44 - 2 + 2.3");
		System.out.println("'b5 formula' would print out 44 - 2 + 2.3");
	}
	
	/*
	 * Goes through each token of the string and checks if they are assigning to a cell.
	 * If they are it will change the cellID to its value.
	 * Ex: b3 = 12
	 * a1 = 33 + b3
	 * Returns 33 + 12
	 */
	public String checkForCellAssign(String cellValue, boolean isNumber, Cell toBeUpdated) {
		String[] tokens = cellValue.split(" ");
		String convertedValue = "";
		boolean cellAssign = false;
		for (int i = 0; i < tokens.length; i++) {
			
			// First tests if the first char is a letter.
			// Second tests if the rest of the string is a numeric value.
			if (tokens[i].substring(0, 1).matches("[a-zA-Z]+") &&
				tokens[i].substring(1).matches("\\d+")) {
				
				cellAssign = true;
				toBeUpdated.setCellInFormula(true);
				int letterIndexAssign = getRowFromCellName(tokens[i]);
				int rowNumberIndexAssign = getColumnFromCellName(tokens[i]);

				if (isNumber) {
					
					tokens[i] = 
							rowsAndColumns[rowNumberIndexAssign][letterIndexAssign].getMathValue();
					
				} else {
					tokens[i] = 
						rowsAndColumns[rowNumberIndexAssign][letterIndexAssign].getCellStringValue();
				}
				
			} 	
				
		}
		
			if (cellAssign) {
			
			for (int i = 0; i < tokens.length; i++) {
				if (i == tokens.length - 1) {
					convertedValue += tokens[i];
				} else {
					convertedValue += tokens[i] + " ";
				}
				
			}
			return convertedValue;
			} else {
			toBeUpdated.setCellInFormula(false);
			return cellValue;
		}
		
	}
	
	public void printFormula(String cell) {
		int col = getColumnFromCellName(cell);
		int row = getRowFromCellName(cell);
		System.out.println(rowsAndColumns[col][row].getFormula());
		System.out.print("Enter next values here: ");
	}

	public Cell[][] getRowsAndColumns() {
		return rowsAndColumns;
	}

	public void setRowsAndColumns(Cell[][] rowsAndColumns) {
		this.rowsAndColumns = rowsAndColumns;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public static int getCellWidth() {
		return cellWidth;
	}

	public static void setCellWidth(int cellWidth) {
		Spreadsheet.cellWidth = cellWidth;
	}
	
}
