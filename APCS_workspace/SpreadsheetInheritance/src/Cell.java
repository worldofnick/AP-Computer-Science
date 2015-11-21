
public class Cell {
	private String cellValue;
	
	Cell() {
		setCellValue("");
	}
	
	Cell(double number){
		setCellValue(Double.toString(number));
	}
	
	Cell(String string) {
	}

	public String getCellValue() {
		return cellValue;
	}

	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}
	
	
}
