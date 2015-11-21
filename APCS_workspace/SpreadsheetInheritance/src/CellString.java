
public class CellString extends Cell {
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
			rowsAndColumns[3][3] = new Cell(-123.45);
			rowsAndColumns[1][0] = new Cell("AP CS");
			
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


}
