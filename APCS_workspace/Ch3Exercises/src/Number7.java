
public class Number7 {

	public static void main(String[] args) {
		largerAbsVal(7, -2, -11);

	}
	private static int largerAbsVal(int first, int second, int third){
		int absFirst = Math.abs(first);
		int absSecond = Math.abs(second);
		int absThird = Math.abs(third);
		int larger = Math.max(absFirst, absSecond);
		int largest = Math.max (larger, absThird);
		System.out.println(largest);
		return larger;
		
	}
	
}
