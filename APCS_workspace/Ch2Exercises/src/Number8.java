
public class Number8 {

	public static void main(String[] args) {
		nested();

	}
	
	private static void nested(){
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
				
			}
				for (int k = 1; k <= i; k++) {
				System.out.print(i);
			}
			System.out.println();
			
			
		}
	}

}
