
public class Main {

	public static void main(String[] args) {
		NestedLoop();
	}

	static void NestedLoop(){
		for (int i = 1; i <= 10; i++) {
			System.out.println("New");
			for (int j = 1; j <= 5; j++) {
				System.out.println(i + " Hi there. " + j);
			}
			
		}
	}
	
}
