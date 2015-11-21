
public class PP1 {

	public static void main(String[] args) {
		printDesign();
	}

	private static void printDesign(){
		int astrickStopper = 1;
		int slashStopper = 1;
		for (int lines = 1; lines <= 7; lines++) {
			for (int firstAstrick = 6; firstAstrick >= astrickStopper; firstAstrick--) {
				System.out.print("*");
			}
				for (int spaces = 1; spaces <= slashStopper; spaces++) {
					System.out.print(" ");
				}
				for (int forwardSlash = 6; forwardSlash >= slashStopper; forwardSlash--) {
					System.out.print("//");
				}
				for (int backSlash = 1; backSlash < slashStopper ; backSlash++) {
					System.out.print("\\\\");
						}
					for (int spaces = 1; spaces <= slashStopper; spaces++) {
								System.out.print(" ");
							}
								for (int secondAstrick = 6; secondAstrick >= astrickStopper; secondAstrick--) {
									System.out.print("*");
								}
				astrickStopper = astrickStopper + 1;
				slashStopper = slashStopper + 1;
				System.out.println();
		}
	}
}
