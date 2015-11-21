
public class NumericCell extends Cell {
	private String formula;
	private double numericValue;
	
	NumericCell(String value) {
		setFormula(value);

	}
	
	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
	
}
