
public class GCDLCMMain {

	public static void main(String[] args) {
		System.out.println(lcm(99,100));

	}
	
	private static int gcd(int a, int b) {
	    while (b > 0)
	    {
	        int temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	
	private static int lcm(int a, int b) {
	    return a * (b / gcd(a, b));
	}

}
