
public class Number8 {

	public static void main(String[] args) {
		quadratic(1,-7,12);
		
	}
	private static double quadratic(double a, double b, double c){
		double root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
		double root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
		System.out.println("X = " + root1 + " X = " + root2);
		return Math.max(root1, root2);
	}
}
