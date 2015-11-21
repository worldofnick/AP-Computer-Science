
public class Accounts {
	// Nick Porter
	private int accountNumber;
	private double currentBalance;
	private double interestRate;

	// Constructs a new account with a account number, balance and interest rate.
	public Accounts(int acctNumber, double initalBalance, double rate) {
		
		setAcctNumber(acctNumber);
		setBalance(initalBalance);
		setRate(rate);
	}

	public double calcIntrest() {
		double intrestAdder = currentBalance * interestRate;
		currentBalance += intrestAdder;
		
		return currentBalance;	
	}
	
	public String toString() {
		String accountInfo = String.format("Account Number: %4d, Balance: %4.2f, Rate: %4.2f",
				accountNumber, currentBalance, interestRate);
		return accountInfo;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getRate() {
		return interestRate;
	}
	
	public double getBalance() {
		return currentBalance;
	}
	
	public void setAcctNumber(int acctNumber) {
		accountNumber = acctNumber;
	}
	
	public void setBalance(double balance) {
		currentBalance = balance;
	}
	
	public void setRate(double rate) {
		interestRate = rate;
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
