
public class MainTimeTables {

	// Nick Porter
	
	static final int END_COUNTER = 5;
	 
	public static void main(String[] args) {
		timesTables();

	}
	
	static void timesTables(){
		for (int i = 1; i <= END_COUNTER ; i++){
			for (int j = 1; j <= END_COUNTER ; j++){
				int output = i * j;
				System.out.printf("%4d ", output);
			}
			System.out.println();
		}
	}
	
}

/*
1    2    3    4    5 
2    4    6    8   10 
3    6    9   12   15 
4    8   12   16   20 
5   10   15   20   25 */
	
	
