
public class Number5 {

	public static void main(String[] args) {
		printGrid(4, 6);
	}
	
	private static void printGrid(int rows, int col){
		for (int i = 1; i <= rows; i++) {
			int output = i;
			for (int j = 1; j <= col; j++) {
				System.out.print(output + " ");
				output = output + rows;
			}
			System.out.println();
			output++;
		}
	}

}
