package newSorter;

import java.util.Date;
import java.util.Random;
// Nick Porter
public class Sorter1 {
	private int[] numberArray;
	private int filledToIndex;
	private long startingTime;
	private long endingTime;
	private long elapsedTime;
	
	public Sorter1(int arraySize) {
		// Add 3 spaces to allow 3 inserts
		this.numberArray = new int[arraySize + 3];
		// This is the highest index that has a value.
		filledToIndex = arraySize - 1;
		
		Random r = new Random();
		for (int i = 0; i <= this.filledToIndex; i++) {
			// Only fills the the part of the array the user will see, sets the last 3 values to 0.
			this.numberArray[i] = r.nextInt(this.filledToIndex);
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
			
		case "selectionsort":
			selectionSort();
			break;
			
		case "shuffle":
			shuffleNumbers();
			break;
			
		case "insertionsort":
			insertionSort();
			break;

		default:
			break;
		}
	}
	
	public void print() {
		/*
		 * If the array is over 50 then it prints the first 15 indexs and the last 15.
		 */
		if (this.filledToIndex > 50) {
			System.out.println("Size: " + this.filledToIndex);
			for (int i = 0; i < 15; i++) {
				System.out.printf("%d\t%d\n", i, numberArray[i]);
			}
			System.out.println("...");
			for (int i = filledToIndex - 15; i <= filledToIndex; i++) {
				System.out.printf("%d\t%d\n", i, numberArray[i]);
			}
			
		} else {
			System.out.println("Size: " + this.filledToIndex);
			for (int i = 0; i <= filledToIndex; i++) {
				System.out.printf("%d\t%d\n", i, numberArray[i]);
			}
		}
	}
	
	public void delete(String indexToRemove) {
		startTimer();
		int indexRemove = 0;
		try {
			indexRemove = Integer.parseInt(indexToRemove);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid index in the array.");
		}
		
		for (int i = indexRemove; i < filledToIndex + 1; i++) {
			this.numberArray[i] = this.numberArray[i + 1];
		}
		this.filledToIndex--;
		stopTimer();	
	}
	
	public void insert(String index, String value) {
		startTimer();
		int insertIndex = 0;
		int insertValue = 0;
		
		// Reduced to only one try-catch
		try {
			insertIndex = Integer.parseInt(index);
			insertValue = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid index in the array.");
		}
		
		// Updated to catch invalid indexes.
		if(insertValue > this.filledToIndex || insertValue < 0 || insertIndex < 0 || insertIndex > this.filledToIndex) {
			throw new ArrayIndexOutOfBoundsException("Please enter a number equal to or less than your array length and greater than - 1");
		} else if(this.filledToIndex == this.numberArray.length - 1) {
			throw new IllegalArgumentException("Your array is full, please remove a number to add more");
		} else {
		
		for (int i = this.filledToIndex; i >= insertIndex; i--) {
			this.numberArray[i + 1] = this.numberArray[i];
		}
		
		/*
		 * I thought about doing by using a stack to hold the values, insert the value then re-insert the held values one index higher.
		 * But this method was more straight forward in my mind.
		 */
		
		this.numberArray[insertIndex] = insertValue;
		this.filledToIndex++;
		stopTimer();
		}
	}
	
	public void selectionSort() {
		/*
		 * With an array size of 1000000 it took 532897 milliseconds running on a dual core 4th gen i5 running OSX.
		 */
		startTimer();
		
		int min;
		for (int i = 0; i < filledToIndex; i++) {
			// Assume the first element is min.
			min = i;
			for(int j = i + 1; j <= filledToIndex; j++) {
				
				if (this.numberArray[j] < this.numberArray[min]) {
					min = j;
				}
				
			}
			
			if(min != i) {
				int temp = this.numberArray[i];
				this.numberArray[i] = this.numberArray[min];
				this.numberArray[min] = temp;
			}
			
		}
		
		stopTimer();
	}
	
	public void shuffleNumbers() {
		startTimer();
		Random random = new Random();
		
		for(int i = 0; i < this.filledToIndex; i++) {
			int randomInt = random.nextInt(this.filledToIndex);
			int temp = this.numberArray[i];
			this.numberArray[i] = this.numberArray[randomInt];
			this.numberArray[randomInt] = temp;
		}
		stopTimer();
	}
	
	public void insertionSort() {
		/*
		 * With an array size of 1000000 it took 489032 milliseconds running on a dual core i5 running OSX.
		 */
		startTimer();
		
		for (int i = 0; i < filledToIndex; i++) {
			int temp = this.numberArray[i];
			int j = i;
			
			while ( j > 0 && this.numberArray[j - 1] > this.numberArray[j]) {
				temp = this.numberArray[j];
				this.numberArray[j] = this.numberArray[j - 1];
				this.numberArray[j - 1] = temp;
				j--;
			}
		
		}

		stopTimer();
	}
	
	private void startTimer() {
		this.startingTime = new Date().getTime();
	}
	
	private void stopTimer() {
		this.endingTime = new Date().getTime();
		this.elapsedTime = this.endingTime - this.startingTime;
		System.out.printf("Elapsed time: \t%d miliseconds.\n", this.elapsedTime);
	}
	
	public void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
}
