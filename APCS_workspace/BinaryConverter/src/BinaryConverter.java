
public class BinaryConverter {
private String digits = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
private String base2String;
private int power;

	
	public int base10ToBase2(int base10) {
		// Reset variables
		this.power = 0;
		this.base2String = "";
		findBiggestPower(base10);
		for (int i = power; i >= 0; i--) {
			if (base10 - Math.pow(2, i) >= 0) {
				this.base2String += "1";
				base10 -= Math.pow(2, i);
			} else {
				this.base2String += "0";
			}
		}
		
		return 0;
		
	}
	
	private void findBiggestPower(int base10) {
		
			for (int i = 0; i < base10; i++) {
				int largestPower = (int) Math.pow(2, i);
				if (largestPower < base10) {
					this.power = i;
				} else {
					break;
				}
			}
	}

	public String toString() {
		while(this.base2String.charAt(0) == '0') {
			this.base2String = base2String.substring(1);
		}
		
		return this.base2String;
	}
	
}
