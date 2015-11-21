
public class Numeber3 {

	public static void main(String[] args) {
		printPowersofN(4, 3);
		printPowersofN(5, 6);
		printPowersofN(-2, 8);

	}
	
	private static void printPowersofN(int base, int exponet){
		for (int i = 0; i <= exponet; i++) {
			System.out.print( (int) Math.pow(base, i) + " " );
		}
		System.out.println();
	}

}
