
public class Number14 {

	public static void main(String[] args) {
		nested14();

	}
	private static void nested14() {
		for (int i = 1; i <= 4; i++) {   // controls how many lines
			for (int j = 9; j >= 1; j--) {  // controls output number
				for (int j2 = 1; j2 <= j; j2++) {  // prints the output number x amount of times each
					System.out.print(j);
					}
				}
			System.out.println();
		}
	}

}
