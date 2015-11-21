
public class BetterCircle {
	
	// Nick Porter

	static double radius =  8.5 * 2;
	static double diameter = radius + radius;
	static double circumfrence = 2.0 * Math.PI * radius;
	static double area = Math.PI * radius * radius;
	static double volume = 4.0 / 3.0 * Math.PI * radius * radius * radius;
	
	public static void main(String[] args) {
		
			printRadius();
			printDiameter();
			printCircumfrence();
			printArea();
			printVolume();
	}
	
	private static void printRadius(){
		System.out.println("Radius is " + radius);
		
	}
	
	private static void printDiameter(){
		System.out.println("Diameter is " + diameter);
	}

	private static void printCircumfrence(){
		System.out.println("Circumfrence is " + circumfrence);
	}
	
	private static void printArea(){
		System.out.println("Area is " + area);
	}

	private static void printVolume(){
		System.out.println("Volume is " + volume);
	}
	

}
