
public class SecondNoMatch {

	// This one does not meet the requirements because the variables are inside the method.
	
	public static void main(String[] args) {
		Fib();

	} 
		static void Fib(){
		int prev = 0;
		int current = 1;
		for (int i = 1 ; i <= 7 ; i++ ){
			int next = prev + current;
			System.out.println(i + ": " + current);
			prev = current;
			current = next;
		}
	}

}
