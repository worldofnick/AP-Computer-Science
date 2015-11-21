
public class Number9 {

	public static void main(String[] args) {
		distance(10, 2, 3, 5);
	}
	
	private static void distance(int x, int y, int x1, int y1){
		double distance = Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y - y1, 2));
		System.out.println(distance);
	}

}
