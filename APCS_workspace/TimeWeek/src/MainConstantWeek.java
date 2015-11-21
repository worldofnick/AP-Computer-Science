
public class MainConstantWeek {
	// Nick Porter
	static final int DAYS_IN_WEEK = 7;
	static final int HOURS_IN_DAY = 24;
	static final int MIN_IN_HOUR = 60;
	static final int SEC_IN_MIN = 60;
	static final int MILISEC_IN_SEC = 1000;
	static final int MICROSEC_IN_MILISEC = 1000;

	public static void main(String[] args) {
		printDaysInWeek();
		printHoursInWeek();
		printMinInWeek();
		printSecInWeek();
		printMilisecInWeek();
		pritnMicrosecInWeek();
		}

	static void printDaysInWeek(){
		int daysInWeek = DAYS_IN_WEEK;
		System.out.println("Days in a week: "+ daysInWeek);
	}
	static void printHoursInWeek(){
		int hoursInWeek = HOURS_IN_DAY * DAYS_IN_WEEK;
		System.out.println("Hours in a week: "+ hoursInWeek);
	}
	static void printMinInWeek(){
		int minInWeek = DAYS_IN_WEEK * HOURS_IN_DAY * MIN_IN_HOUR;
		System.out.println("Minutes in a week: " + minInWeek);
	}
	static void printSecInWeek(){
		int secInWeek = DAYS_IN_WEEK * HOURS_IN_DAY * MIN_IN_HOUR * SEC_IN_MIN;
		System.out.println("Seconds in a week: " + secInWeek);
	}
	static void printMilisecInWeek(){
		int milisecInWeek = DAYS_IN_WEEK * HOURS_IN_DAY * MIN_IN_HOUR * SEC_IN_MIN * MILISEC_IN_SEC;
		System.out.println("Milliseconds in a week: " + milisecInWeek);
	}
	static void pritnMicrosecInWeek(){
		double microsecInWeek = (double) DAYS_IN_WEEK * HOURS_IN_DAY * MIN_IN_HOUR * SEC_IN_MIN * MILISEC_IN_SEC *  MICROSEC_IN_MILISEC;
		System.out.println("Microseconds in a week: " + microsecInWeek);
	}
	
	/* 
	Days in a week: 7
	Hours in a week: 168
	Minutes in a week: 10080
	Seconds in a week: 604800
	Milliseconds in a week: 604800000
	Microseconds in a week: 6.048E11
	*/
}


