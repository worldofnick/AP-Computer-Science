
public class BankAcctMain {
	// Nick Porter
	public static void main(String[] args) {
		makeAccounts();
	}
	
	private static void makeAccounts() {
		Accounts account1 = new Accounts(1357, 1000, 0.03);
		
		Accounts account2 = new Accounts(2468, 1000, 0.04);
		
		Accounts account3 = new Accounts(9876, 1000, 0.05);
		
		printAccounts(account1, account2, account3);
		
	}

	private static void printAccounts(Accounts account1, Accounts account2,
			Accounts account3) {

		System.out.println("Year " + 0);
		System.out.printf("Account Number: %4d, Balance: %4.2f, Rate: %4.2f\n", account1.getAccountNumber(),
				account1.getBalance(), account1.getRate());
		
		System.out.printf("Account Number: %4d, Balance: %4.2f, Rate: %4.2f\n", account2.getAccountNumber(),
				account2.getBalance(), account2.getRate());
		
		System.out.printf("Account Number: %4d, Balance: %4.2f, Rate: %4.2f\n", account3.getAccountNumber(),
				account3.getBalance(), account3.getRate());
		
		for (int i = 1; i <= 10; i++) {
			account1.calcIntrest();
			account2.calcIntrest();
			account3.calcIntrest();
			
			System.out.println("Year " + i);
			System.out.printf("Account Number: %4d, Balance: %4.2f, Rate: %4.2f\n", account1.getAccountNumber(),
					account1.getBalance(), account1.getRate());
			
			System.out.printf("Account Number: %4d, Balance: %4.2f, Rate: %4.2f\n", account2.getAccountNumber(),
					account2.getBalance(), account2.getRate());
			
			System.out.printf("Account Number: %4d, Balance: %4.2f, Rate: %4.2f\n", account3.getAccountNumber(),
					account3.getBalance(), account3.getRate());
		}
	}

}

/*
Year 0
	Account Number: 1357, Balance: 1000.00, Rate: 0.03
	Account Number: 2468, Balance: 1000.00, Rate: 0.04
	Account Number: 9876, Balance: 1000.00, Rate: 0.05
Year 1
	Account Number: 1357, Balance: 1030.00, Rate: 0.03
	Account Number: 2468, Balance: 1040.00, Rate: 0.04
	Account Number: 9876, Balance: 1050.00, Rate: 0.05
Year 2
	Account Number: 1357, Balance: 1060.90, Rate: 0.03
	Account Number: 2468, Balance: 1081.60, Rate: 0.04
	Account Number: 9876, Balance: 1102.50, Rate: 0.05
Year 3
	Account Number: 1357, Balance: 1092.73, Rate: 0.03
	Account Number: 2468, Balance: 1124.86, Rate: 0.04
	Account Number: 9876, Balance: 1157.63, Rate: 0.05
Year 4
	Account Number: 1357, Balance: 1125.51, Rate: 0.03
	Account Number: 2468, Balance: 1169.86, Rate: 0.04
	Account Number: 9876, Balance: 1215.51, Rate: 0.05
Year 5
	Account Number: 1357, Balance: 1159.27, Rate: 0.03
	Account Number: 2468, Balance: 1216.65, Rate: 0.04
	Account Number: 9876, Balance: 1276.28, Rate: 0.05
Year 6
	Account Number: 1357, Balance: 1194.05, Rate: 0.03
	Account Number: 2468, Balance: 1265.32, Rate: 0.04
	Account Number: 9876, Balance: 1340.10, Rate: 0.05
Year 7
	Account Number: 1357, Balance: 1229.87, Rate: 0.03
	Account Number: 2468, Balance: 1315.93, Rate: 0.04
	Account Number: 9876, Balance: 1407.10, Rate: 0.05
Year 8
	Account Number: 1357, Balance: 1266.77, Rate: 0.03
	Account Number: 2468, Balance: 1368.57, Rate: 0.04
	Account Number: 9876, Balance: 1477.46, Rate: 0.05
Year 9
	Account Number: 1357, Balance: 1304.77, Rate: 0.03
	Account Number: 2468, Balance: 1423.31, Rate: 0.04
	Account Number: 9876, Balance: 1551.33, Rate: 0.05
Year 10
	Account Number: 1357, Balance: 1343.92, Rate: 0.03
	Account Number: 2468, Balance: 1480.24, Rate: 0.04
	Account Number: 9876, Balance: 1628.89, Rate: 0.05
	*/