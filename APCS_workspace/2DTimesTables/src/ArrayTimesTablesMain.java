import java.util.Scanner;

public class ArrayTimesTablesMain {

	// Nick Porter
	public static void main(String[] args) {
		takeUserInput();
	}

	private static void takeUserInput() {
		Scanner userInput = new Scanner(System.in);
		int tableArray[][];

		System.out.print("Enter the size of the times table: ");
		int sizeOfTimesTable = userInput.nextInt();

		tableArray = new int[sizeOfTimesTable + 1][sizeOfTimesTable + 1];

		fillArray(tableArray);
		printArray(tableArray);

		userInput.close();
	}

	private static int[][] fillArray(int timesTable[][]) {

		for (int row = 0; row < timesTable.length; row++) {
			timesTable[row][row] = row;
			for (int column = 0; column < timesTable.length; column++) {
				timesTable[row][column] = column * row;
			}
		}

		return timesTable;
	}

	private static void printArray(int timesTable[][]) {

		System.out.printf("%5d|", timesTable.length - 1);
		for (int i = 0; i < timesTable.length; i++) {
			System.out.printf("%5d", i);
		}
		System.out.println();
		System.out.print("-");

		for (int i = 0; i < timesTable.length + 1; i++) {
			System.out.print("-----");
		}
		System.out.println();

		for (int i = 0; i < timesTable.length; i++) {
			System.out.printf("%5d|", i);
			for (int j = 0; j < timesTable.length; j++) {
				System.out.printf("%5d", timesTable[i][j]);
			}
			System.out.println();
		}

	}

}

/*
Enter the size of the times table: 10
10|    0    1    2    3    4    5    6    7    8    9   10
-------------------------------------------------------------
 0|    0    0    0    0    0    0    0    0    0    0    0
 1|    0    1    2    3    4    5    6    7    8    9   10
 2|    0    2    4    6    8   10   12   14   16   18   20
 3|    0    3    6    9   12   15   18   21   24   27   30
 4|    0    4    8   12   16   20   24   28   32   36   40
 5|    0    5   10   15   20   25   30   35   40   45   50
 6|    0    6   12   18   24   30   36   42   48   54   60
 7|    0    7   14   21   28   35   42   49   56   63   70
 8|    0    8   16   24   32   40   48   56   64   72   80
 9|    0    9   18   27   36   45   54   63   72   81   90
10|    0   10   20   30   40   50   60   70   80   90  100
*/

