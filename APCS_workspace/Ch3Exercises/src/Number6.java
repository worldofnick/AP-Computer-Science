
public class Number6 {

	public static void main(String[] args) {
		largerAbsVal(11, 2);
		largerAbsVal(4, -5);

	}
	
	private static int largerAbsVal(int first, int second){
		int absFirst = Math.abs(first);
		int absSecond = Math.abs(second);
		int larger = Math.max(absFirst, absSecond);
		System.out.println(larger);
		return larger;
		
	}

}
