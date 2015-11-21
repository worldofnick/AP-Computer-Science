
public class Number13 {

	public static void main(String[] args) {
		nested13();

	}
	private static void nested13() {
		for (int i = 1; i <= 5; i++) {   // controls how many lines
			for (int j = 9; j >= 0; j--) {  // controls output number
				for (int j2 = 1; j2 <= 5; j2++) {  // prints the output number x amount of times each
					System.out.print(j);
					}
				}
			System.out.println();
		}
	}

}
