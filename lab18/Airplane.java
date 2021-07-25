package lab18;

public class Airplane extends Vehicle{
	private String flightNumber;
	
	public Airplane() {
		flightNumber = "";
	}
	
	public Airplane (int numberOfSeats, int numberOfPassengers, Point currentPosition, Point destination, int topSpeed, String flightNumber) {
	    super (numberOfSeats, numberOfPassengers, currentPosition, destination, topSpeed);
	    this.flightNumber = flightNumber;
	  }
	
	public void communicate() {
		System.out.println("Tower, this is flight " + flightNumber + ". Requesting permission to land");
	}
	
	public String toString() {
		return "This is an airplane, flight number " + flightNumber + ".";
	}
}
