
public class HarvardLawyer extends Lawyer {

	public double getSalary() {
		double percentage = super.getSalary() * .20;
		return super.getSalary() + percentage;
	}
	
	public int getVacationDays() {
		return super.getVacationDays() + 3;
	}
	
	public String getVacationForm() {
		String addedString = "";
		for (int i = 0; i < 4; i++) {
			addedString += super.getVacationForm();
		}
		
		return addedString;
	}
	
}
