
public class Number4 {

	public static void main(String[] args) {
		printBox();

	}

	static void printBox(){
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5 ; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
	}
}
