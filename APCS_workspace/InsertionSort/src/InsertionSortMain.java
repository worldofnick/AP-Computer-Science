
public class InsertionSortMain {

	public static void main(String[] args) {
		
		int[] intArray = new int[] {44,5,6,77,8,12,498,78,456,13,664,654,997,465,4658,6664,1};
		selectionSort(intArray);
		//insertionSort(intArray);

		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
	}

	private static void insertionSort(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			int temp = intArray[i];
			int j = i;
			
			while ( j > 0 && intArray[j - 1] > intArray[j]) {
				temp = intArray[j];
				intArray[j] = intArray[j - 1];
				intArray[j - 1] = temp;
				j--;
			}
			
		}
	}
	
	private static void selectionSort(int[] intArray) {
		
		for (int i = 0; i < intArray.length; i++) {
			int min = i;
			
			for (int j = i + 1; j < intArray.length; j++) {
				
				if (intArray[j] < intArray[min]) {
					min = j;
				}
				
			}
			if(min != i) {
				int temp = intArray[i];
				intArray[i] = intArray[min];
				intArray[min] = temp;
			}
			
			
		}
		
	}

}
