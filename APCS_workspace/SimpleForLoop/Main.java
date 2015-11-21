
public class Main {
	
	static int divisor = 17;

	public static void main(String[] args) {
		forLoop();
		
	}
	
	static void forLoop(){
		for (int i = -1000000; i <= 1000000; i++)
			System.out.println(i % divisor);

	}

}
