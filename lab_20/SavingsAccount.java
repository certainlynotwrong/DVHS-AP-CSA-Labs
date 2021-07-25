package lab_20;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount() {
		interestRate = 0;
	}
	
	public SavingsAccount(String n, double b, double i) {
		super(n, b);
		this.interestRate = i;
	}
	
	public void applyInterest() {
		deposit(getBalance() * (interestRate / 12));
	}
	
	public String toString() {
		return "Name: " + getName() + ", Savings Acct: " + getAccountNumber() + ", Balance: " + getBalance() + ", "
				+ "Interest: " + (interestRate * 100) + "%";
	}
}


