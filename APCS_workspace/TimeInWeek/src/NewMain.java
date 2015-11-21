
public class NewMain {
	
	static int daysInWeek = 7;
	static int hoursInWeek = daysInWeek * hoursInDay;
	static int minutesInWeek = secondsInMinute * daysInWeek * hoursInDay;
	static int secondsInWeek = secondsInMinute * minutesInWeek;
	static int millisecondsInWeek = millisecondsInSecond * secondsInWeek;
	static double microsecondsInWeek = microsecondsInSecond * (double) secondsInWeek;

	public static void main(String[] args) {
			daysInWeek();

	}
	
	static void daysInWeek(){
		int DaysInWeek = 7;
		System.out.println(DaysInWeek);
	}
	
	static void hoursInWeek(){
		int HoursInWeek = 0;
	}

}
