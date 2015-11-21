import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class RearrangedMain {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner numberFiles = new Scanner(new File("numbers.txt"));
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		Queue<Integer> outputQueue = new LinkedList<Integer>();
		boolean refill = false;
		
		int index = 0;
		while (numberFiles.hasNext()) {
			numberList.add(numberFiles.nextInt());			
			index++;
		}
		
		for (int i = 0; i < numberList.size(); i++) {
			
			int numberToBeAdded = numberList.remove();
			System.out.println(i);
			
			if (outputQueue.isEmpty()) {
				outputQueue.add(numberList.remove());
			} else {
				
				Queue<Integer> holderQueue = new LinkedList<Integer>();
				while (numberToBeAdded < outputQueue.peek() || !outputQueue.isEmpty()) {
					holderQueue.add(outputQueue.remove());
					refill = true;
				}
				
				outputQueue.add(numberToBeAdded);
				
				if (refill) {
					for (int j = 0; j < holderQueue.size(); j++) {
						outputQueue.add(holderQueue.remove());
					}
				}
				
			}
			
		}

	}

}
