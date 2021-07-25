package lab_14;

public class BankAccount {
	private double balance;
	private String name;
	public int accountNumber;
	
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setBalance(double newBalance) {
		balance = newBalance;
	}
	//Creates instance variables for accountNubmer / number of accounts created
	public static int numberOfAccountsCreated = 0;
	
	private static int getAccountNumber() {
		return accountNumber;
	}
	
	private static int getnumberOfAccountsCreated() {
		return numberOfAccountsCreated;
	}
	
	
	  public BankAccount(){
		    setName("");
		    name = "";
		    numberOfAccountsCreated++;
		    accountNumber = 10000000 + numberOfAccountsCreated;
			if(accountNumber % 100 == 0) { // if at the 100th bankaccount
				  balance += 100.0; // add 100 to balance
			}
	}
	  
	  public BankAccount(String n, double b) {
		  setName(n);
		  numberOfAccountsCreated++;
		  accountNumber = 10000000 + numberOfAccountsCreated;
		  if(numberOfAccountsCreated % 100 == 0) { // if at the 100th bank account
			  setBalance(100 + b); // add 100 to balance
		  } else {
			  setBalance(b); // or not, don't change
		  }
	  }
	  
	  public String toString() {
		    return name + "'s bank account " + getAccountNumber()
		      + " has a balance of $" + balance;
	  }
	  
	  public void deposit(double money) {
		  if(money <= 0) { // check if user is attempting to deposit nothing or a negative amount
			  System.out.println("Invalid deposit amount.");
			  return;
		  } else {
		  balance += money; // add deposited money
		  System.out.println(money + "successfully deposited. Balance is now " + balance);
		  }
	  }
	  
	  public double withdraw(double with) {
		  if(with < balance) { // checks if user withdrawing more money than in the actual account
			  balance = balance - 10; // removes 10 from the user's balance
			  return 0;
		  } else {
			  balance = balance - with; // subtracts requested amount
			  return with; // return the amount withdrawn
		  }
	  }
	

}
