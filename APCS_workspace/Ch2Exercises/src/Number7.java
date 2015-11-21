
public class Number7 {

	public static void main(String[] args) {
		backwardsLoop();

	}
	static void backwardsLoop(){
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
				for (int j2 = 1; j2 <= j; j2++) {
					System.out.print(j2);
					
				}
			}
			System.out.println();
		}
	}

}
