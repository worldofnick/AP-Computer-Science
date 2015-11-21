import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ZipCodeMain {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("zipcode.txt"));
		intro();
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("What zip code are you interested in? ");
		String zipcode = userInput.nextLine();
		
		System.out.print("And what proximity (in miles)? ");
		double prox = userInput.nextDouble();
		
		userInput.close();
		
		String targetCords = findZipCode(zipcode, input);
		
		Scanner console = new Scanner(new File("zipcode.txt"));
		showMatches(zipcode, targetCords, console, prox);
	}
	
	private static void intro() {
		System.out.println("Welcome to the zip code database.");
		System.out.println("Give me a 5-digit zip code and a");
		System.out.println("proximity, and I'll tell you where");
		System.out.println("that zip code is located, along");
		System.out.println("with a list of other zip codes");
		System.out.println("within the given proximity.");
		System.out.println();
	}
	
	private static String findZipCode(String targetZip, Scanner input) {
		
		while (input.hasNext()) {
			String zipcode = input.nextLine();
			String city = input.nextLine();
			String longAndLat = input.nextLine();
			
			if (zipcode.equals(targetZip)) {
				System.out.println();
				System.out.printf("%s: %s\n", zipcode, city);
				return longAndLat;
			}
			
		}
		
		return "0,0";
	}
	
	private static void showMatches(String currentZip, String targetCords, Scanner console, double miles ) {
		System.out.println("Zip codes within " + miles + " miles:");
		Scanner consumeCordinates = new Scanner(targetCords);
		double long1 = consumeCordinates.nextDouble();
		double lat1 = consumeCordinates.nextDouble();
		consumeCordinates.close();
		
		while(console.hasNext()) {
			String zipcode = console.nextLine();
			String city = console.nextLine();
			String longAndLat = console.nextLine();
			
			Scanner consumeNewCordinates = new Scanner(longAndLat);
			double long2 = consumeNewCordinates.nextDouble();
			double lat2 = consumeNewCordinates.nextDouble();
			consumeNewCordinates.close();
			
			double distance = distance(lat1, long1, lat2, long2);
			
			if (distance <= miles && !currentZip.equals(zipcode)) {
				System.out.printf("\t%s %s, %.2f miles\n", zipcode, city, distance);
			}
		}
	}
	
	private static double distance(double lat1, double long1, double lat2, double long2) {
		 final double RADIUS = 3958.76;
		 lat1 = Math.toRadians(lat1);
		 long1 = Math.toRadians(long1);
		 lat2 = Math.toRadians(lat2);
		 long2 = Math.toRadians(long2);
		 
		 double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2);
		 double arcLength = Math.acos(theCos);
		 
		 return arcLength * RADIUS;
	
	}

}
