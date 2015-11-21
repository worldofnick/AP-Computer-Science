
public class MainLoop {

	// Nick Porter
	static int max = 1000000;
	static int min = -1000000;
	
	public static void main(String[] args) {
		forLoop();
	}

	static void forLoop(){
		for (int i = min ; i <= max ; i++){
			int divisor = 17;
			int result = i % divisor;
			String output = i + " % " + divisor + " = " + result ;
			
			System.out.println(output);
			
		}
	}
}
