
public class Main {

	// Nick Porter
	
	
	
	public static void main(String[] args) {
		printRadius();
		printDiameter();
		printCircumference();
		printArea();
		printVolume();

	}

	private static void printArea(){
		System.out.println("Area is: " + 3.141 *17 *17);
	}
	
	private static void printRadius(){
		System.out.println("Radius is " + 8.5 * 2);
	}
	
	private static void printDiameter(){
		System.out.println("Diameter is: " + 17 * 2);
	}
	
	private static void printCircumference(){
		System.out.println("Circumference is " + 2.0 * 3.141 * 17.0 );
	}
	
	private static void printVolume(){
		System.out.println("Volume  is: " + 4.0 / 3.0 * 3.141 * 17 * 17 *17  );
	}
}


