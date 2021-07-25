package lab_20;

public class Account {
	private String name;
	private static int accountsCreated = 0;
	private int accountNumber = 10000000;
	private double balance;
	private String[] transactions;
	private String description;
	
	
	public Account() {
		name = "";
		accountNumber = 10000000 + accountsCreated;
		accountsCreated++;
		balance = 0;
		transactions = null;
		}
	
	public Account(String n, double b) {
		name = n;
		accountNumber += accountsCreated;
		accountsCreated++;
		balance = b;
		transactions = null;
	}
	
	

	public void deposit(double amt) {
		balance += amt;
		if(transactions == null) {
			transactions = new String[] {"depositing: " + amt};
		} else {
			String[] nT = new String[transactions.length + 1];
			for(int i = 0; i < transactions.length; i++) {
				nT[i] = transactions[i];
			}
			nT[nT.length - 1] = "depositing " + amt;
			transactions = nT;
		}
	}
	
	public double withdraw(double amt) {
		balance -= amt;
		if(transactions == null) {
			transactions = new String[] {"withdrawing: " + amt};
		} else {
			String[] nT = new String[transactions.length + 1];
			for(int i = 0; i < transactions.length; i++) {
				nT[i] = transactions[i];
			}
			nT[nT.length - 1] = "withdrawing " + amt;
			transactions = nT;
		}
		return balance;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String d) {
		description = d;
	}
	
	
	public void setName(String n) {
		name = n;
	}
	
	public String toString() {
		return "Name: " + name + ", Account number: " + accountNumber + ", Balance: $" + balance + ", Transaction" + transactions;
		}	
	

	public static void main(String[] args) {
		
	}
}
