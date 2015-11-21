import java.util.Scanner;


public class CircleMain {

	public static void main(String[] args) {
		int i = 14;
		Scanner scan = new Scanner(System.in);
		
		Circle circle1 = new Circle();
		
		// Sets the radius variable in Circle class to 17.
		circle1.radius = 17;
		circle1.calculate();
		
		// Prints the area variable in the circle class.
		System.out.printf("Circle 1 area: %f\n", circle1.area);
		System.out.printf("With toString: %s\n", circle1);
		
		Circle circle2 = new Circle();
		circle2.radius = 42;
		circle2.calculate();
		
		// Prints the area variable in the circle class.
		System.out.printf("Circle 2 area: %f\n", circle2.area);

	}

}
