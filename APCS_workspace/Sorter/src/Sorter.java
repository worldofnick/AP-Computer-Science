import java.util.Date;
import java.util.Random;


public class Sorter {
	
	private long startingTime;
	private long endTime;
	private long elapsedTime;
	private int[] array;
	private int fillLine;
	
	public Sorter(int arraySize) {
		this.array = new int[arraySize + 3];
		this.fillLine = arraySize - 1;
		
		Random r = new Random();
		for (int i = 0; i < array.length - 3; i++) {
			array[i] = r.nextInt(fillLine);
		}
	}
	
	public void takeInput(String s) {
		String[] stringToken = s.split(" ");
		
		switch (stringToken[0]) {
		case "print":
			print();
			break;
			
		case "delete":
			delete(stringToken[1]);
			break;
			
		case "insert":
			insert(stringToken[1], stringToken[2]);
			break;

		default:
			break;
		}
	}
	
	public void print() {
		System.out.println(this.fillLine);
		if (this.array.length > 50) {
			System.out.println("Size: " + this.fillLine);
			for (int i = 0; i <= 15; i++) {
				System.out.printf("%d\t%d\n", i, array[i]);
			}
			System.out.println("...");
			for (int i = array.length - 15; i <= fillLine; i++) {
				System.out.printf("%d\t%d\n", i, array[i]);
			}
			
		} else {
			System.out.println("Size: " + this.fillLine);
			for (int i = this.fillLine - 15; i <= fillLine; i++) {
				System.out.printf("%d\t%d\n", i, array[i]);
			}
		}
	}
	
	public void delete(String indexRemove) {
		startTimer();
		int indexToRemove = 0;
		try {
			indexToRemove = Integer.parseInt(indexRemove);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid index in the array.");
		}
		
		for (int i = indexToRemove; i < fillLine; i++) {
			this.array[i] = this.array[i + 1];
		}
		
		stopTimer();
		System.out.printf("Elapsed time: \t%d miliseconds.\n", this.elapsedTime);
	}
	
	public void insert(String index, String value) {
		startTimer();
		int insertIndex = 0;
		int insertValue = 0;
		
		try {
			insertIndex = Integer.parseInt(index);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid index in the array.");
		}
		
		try {
			insertValue = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid index in the array.");
		}
		
		if (insertIndex > array.length || insertIndex < 0) {
			throw new ArrayStoreException("Please specify a valid index in the array.");
		} else if (fillLine == this.array.length - 1) {
			throw new ArrayStoreException("The array is currently full, please remove a value to insert a new one");
		}
		
		if (insertIndex == 0) {
			for (int i = fillLine; i >= fillLine - insertIndex; i--) {
				this.array[i + 1] = this.array[i];
			}
		} else {
			for (int i = fillLine; i > fillLine - insertIndex; i--) {
				this.array[i + 1] = this.array[i];
			}
		}	
		
		this.array[insertIndex] = insertValue;
		this.fillLine++;
		stopTimer();
		System.out.printf("Elapsed time: \t%d miliseconds.\n", this.elapsedTime);
		
	}
	
	private void startTimer() {
		this.startingTime = new Date().getTime();
	}
	
	private void stopTimer() {
		this.endTime = new Date().getTime();
		this.elapsedTime = this.endTime - this.startingTime;
	}

	
}
