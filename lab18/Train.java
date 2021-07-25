package lab18;

public class Train extends Vehicle {
	private int boxcars;
	
	public Train() {
		boxcars = 0;
	}
	
	public Train (int numberOfSeats, int numberOfPassengers, Point currentPosition, Point destination, int topSpeed, int numberOfBoxcars) {
	    super (numberOfSeats, numberOfPassengers, currentPosition, destination, topSpeed);
	    this.boxcars = numberOfBoxcars;
	  }
	
	public void communicate() {
		System.out.println("I think I can, I think I can!");
	}
	
	public String toString() {
		return "This is a train, all aboard!";
	}
	
}
