
package lab_14;
import​ ​java​.​util​.​Scanner​;

public class Main {
//Only code written in side the BankAccount class can see private variables/methods
	
	public static void main(String[] args) {
		//BankAccount a = new BankAccount("Al", 1.01);
		//System.out.println(a.toString());
		
		
		/*
		BankAccount myAccount = new BankAccount();
		myAccount.name = "Bill";
		myAccount.balance = 0.01;
		System.out.println("ur gaye");
		
		
		BankAccount al = new BankAccount();
		al.setName("Al");
		al.setBalance(50.00);
		BankAccount bob = new BankAccount();
		bob.setName("Bob");
		bob.setBalance(25.00);
		BankAccount carl = new BankAccount();
		carl.setName("Carl");
		carl.setBalance(44.00);
		
		
		
		BankAccount a = new BankAccount();
		BankAccount b = new BankAccount();
		BankAccount.numberOfAccountsCreated = 1;
		a.accountNumber = 100;
		a.numberOfAccountsCreated = 1;
		*/
		
		/*BankAccount[] fin = new BankAccount[500];
		for(int i = 0; i < 500; i++) {
			fin[i] = new BankAccount("Acct" + (i+1), i + 1);
			System.out.println(fin[i].toString());
		}*/

		Scanner userchoice = new Scanner(System.in);
		BankAccount [] acc = new BankAccount[100];
		int userin = 0;

		while(userin < 3) {
			System.out.println("\n Welcome to the Bank, what do you want to do?");
			System.out.println("1. Create new account");
			System.out.println("2. View all accounts");
			System.out.println("3. Quit");
			System.out.println("Enter your selection: ");
			int re = input.nextInt();
			if(res ==1) {
				System.out.println("You chose option 1");
				input.nextLine();
				System.out.println("Name?");
				String name = input.nextLine();
				System.out.println("Initial desposit?");
				double d = input.nextDouble();
				if(d <=0 ) {
					continue;
				}

				acc[userin] = new BankAccount(name, d);
				userin++;
				System.out.println("Account(s) successfully created");
			} else if {
				for(int i = 0; i < BankAccount.getNumberOfAccountsCreated(); i++) {
					System.out.println(acc[i].getName() + ": " + acc[i].getBalance());
				}
			} else {
				System.out.println("Goodbye");
				break;
			}
		}
	}
	

	

	
	


}
