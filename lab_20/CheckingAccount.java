package lab_20;

public class CheckingAccount extends Account{
	
	public CheckingAccount() {
	}
	
	public CheckingAccount(String n, double b) {
		super(n, b);
	}
	
	
	
	public String toString () {
		return "Name: " + getName() + ", Checking Account: " + getAccountNumber() + " , Balance: " + getBalance();
	}
}
