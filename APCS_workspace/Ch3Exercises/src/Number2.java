
public class Number2 {

	public static void main(String[] args) {
		printPowersOf2(3);
		printPowersOf2(10);

	}
	
	private static void printPowersOf2(int power){
		for (int input = 0; input <= power; input++) {
			System.out.print((int) Math.pow(2, input) + " ");
			
		}
		System.out.println();
	}

}
