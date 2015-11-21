
public class Main {
	
	
	static int hoursInWeek = daysInWeek * hoursInDay;
	static int minutesInWeek = secondsInMinute * daysInWeek * hoursInDay;
	static int secondsInWeek = secondsInMinute * minutesInWeek;
	static int millisecondsInWeek = millisecondsInSecond * secondsInWeek;
	static double microsecondsInWeek = microsecondsInSecond * (double) secondsInWeek;

	public static void main(String[] args) {
		
		daysInWeek();

	}
	
		private static void daysInWeek(){
			int days = 7;
			System.out.println(days);
		}

}
