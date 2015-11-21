
public class GCDMain {
// Nick Porter
	public static void main(String[] args) {
		returnValues();
	}
	
	private static int GCD(int a, int b){
		a = Math.abs(a);
		b = Math.abs(b);
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (a > 0) {
			int x = b % a;
			b = a;
			a = x;
		}
		return b;
	}
	private static int LCM(int a, int b){
		int LCM = Math.abs(a * b) / GCD(a, b);
		return LCM;	
	}
	
	private static void returnValues(){
		System.out.printf("%6s %6s %6s %6s\n", "A", "B", "GCD", "LCM");
		System.out.printf("%6s %6s %6s %6s\n", "-----  ", "-----  ", "-----  ", "-----  ");
		for (int i = 4; i <= 16; i = i + 4) {
			for (int j = 9; j <= 27; j = j + 9) {
				System.out.printf("%5d %7d %7d %7d\n", i, j, GCD(i, j), LCM(i, j));
			}
		}
	}
}
/*
     A      B    GCD    LCM
-----   -----   -----   -----  
    4       9       1      36
    4      18       2      36
    4      27       1     108
    8       9       1      72
    8      18       2      72
    8      27       1     216
   12       9       3      36
   12      18       6      36
   12      27       3     108
   16       9       1     144
   16      18       2     144
   16      27       1     432
    */
