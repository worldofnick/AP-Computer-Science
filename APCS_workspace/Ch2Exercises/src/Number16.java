
public class Number16 {

	public static void main(String[] args) {
		nested16();

	}
	
	private static void nested16(){
		int stopper = 2;
		for (int lines = 1; lines <= 6; lines++) {
			for (int firstDash = 1; firstDash <= stopper; firstDash++) {
				System.out.print("\\");
			}
				for (int exclamation = 22; exclamation >= 2; exclamation = exclamation - 4) {
					System.out.print("!");
				}
			System.out.println();
			stopper = stopper + 2;
		}
		
	}

}
