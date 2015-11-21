
public class Main {	
	// Nick Porter
		
		static int days = 7;
		static int hours = days * 24;
		static int min = hours * 60;
		static int seconds = min * 60;
		static int milliseconds = seconds * 1000;
		static double microseconds = milliseconds * 1000.0;
				
	public static void main(String[] args) {
		printDaysInWeek();
		printHoursInWeek();
		printMinInWeek();
		printSecondsInWeek();
		printMillisecondsInWeek();
		printMicrosecondsInWeek();
	}
	
	static void printDaysInWeek(){
		System.out.println("Days in a week: " + days);
	}
	
	static void printHoursInWeek(){
		System.out.println("Hours in a week: " + hours);
	}
	
	static void printMinInWeek(){
		System.out.println("Minutes in a week: " + min);
	}
	
	static void printSecondsInWeek(){
		System.out.println("Seconds in a week: " + seconds);
	}
	
	static void printMillisecondsInWeek(){
		System.out.println("Milliseconds in a week: " + milliseconds);
	}
	
	static void printMicrosecondsInWeek(){
		System.out.println("Microseconds in a week: " + microseconds );
	}

}

/* 
OUTPUT:
Days in a week: 7
Hours in a week: 168
Minutes in a week: 10080
Seconds in a week: 604800
Milliseconds in a week: 604800000
Microseconds in a week: 6.048E11
*/
