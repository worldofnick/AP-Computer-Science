
public class Number12 {

	public static void main(String[] args) {
		nested12();
	}
	
	private static void nested12() {
		for (int i = 1; i <= 3; i++) {   // controls how many lines
			for (int j = 0; j <= 9 ; j++) {  // controls output number
				for (int j2 = 1; j2 <= 3; j2++) {  // prints the output number x amount of times each
					System.out.print(j);
					}
				}
			System.out.println();
		}
	}

}
