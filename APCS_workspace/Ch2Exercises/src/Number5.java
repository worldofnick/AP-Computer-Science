
public class Number5 {

	public static void main(String[] args) {
		printLoop();

	}
	
	static void printLoop(){
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
