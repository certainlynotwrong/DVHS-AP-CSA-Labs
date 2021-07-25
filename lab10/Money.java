package lab10;

public class Money {
	public int dollars;
	public int cents;
	
	Money(int amount) {
		this.dollars = amount / 100;
		this.cents = amount % 100;
	}
	
	Money(int a1, int a2) {
		this.dollars = a1;
		this.cents = a2;
	}
	public String result; // initialize string of dollar and cent values
	
}




