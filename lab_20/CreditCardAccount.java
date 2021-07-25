package lab_20;

public class CreditCardAccount extends Account {
	private double interestRate;
	private String description; // Visa, Mastercard, Amex
	
	public CreditCardAccount() {
		interestRate = 0;
		description = "";
	}
	
	public CreditCardAccount(String n, double b, String t, double i) {
		super(n, b);
		this.description = t;
		this.interestRate = i;
	}
	
	public void chargeInterest() {
		withdraw(getBalance() * (interestRate / 12));
	}
	
	public void charge(double amt) {
		withdraw(amt);
	}
	
	public void pay(double amt) {
		deposit(amt);
	}
	
	
	public String toString() {
		return "Name: " + getName() + ", " + getDescription() + " Acct: " + getAccountNumber() 
		+ ", Balance: " + getBalance() + " Interest: " + (interestRate * 100) + "%"; 
	}
	
	
}
