
public class Number1 {

	public static void main(String[] args) {
		printNumbers(15);
		printNumbers(5);

	}
	
	private static int printNumbers(int max){
		for (int starter = 1; starter <= max; starter++) {
			System.out.print("[" + starter + "]");
		}
		System.out.println();
		return max;
	}
	
}
