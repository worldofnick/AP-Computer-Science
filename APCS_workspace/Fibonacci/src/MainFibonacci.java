
public class MainFibonacci {
	//Nick Porter
	
	// two variables to track previous and current.
	
	static int previous = 0;
	static int current = 1;
	
	
	
	public static void main(String[] args) {
		Fibonacci();
		
	}

	static void Fibonacci(){
		
		for (int i = 0 ;  i <= 40 ; i++){
			previous = previous + current; 
			current = previous - current;
			System.out.println(i + " :" + current);
			 
		 
		}
			
		}
	
/* 36 :14930352
37 :24157817
38 :39088169
39 :63245986
40 :102334155
*/
	
	}

