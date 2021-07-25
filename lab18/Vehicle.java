package lab18;

public class Vehicle {
	
	private int seats;
	private int passengers;
	private Point currentLocation;
	private Point destination;
	private int topSpeed;
	
	
	public Vehicle() {
		seats = 0;
		passengers = 0;
		currentLocation = new Point();
		destination = new Point();
	}
	
	public Vehicle(int seats, int passengers, Point currentLocation, Point destination, int topSpeed) {
		this.seats = seats;
		this.passengers = passengers;
		this.currentLocation = currentLocation;
		this.destination = destination;
		this.topSpeed = topSpeed;
	}
	
	public void communicate() {
		System.out.println("Hey you!");
	}

	public String toString() {
		return "This is a vehicle.";
	}
	
	public int speedCompareTo(Vehicle v) {
		return this.topSpeed - v.topSpeed;
	}
	
	public double distanceTo(Vehicle v) {
		return currentLocation.distance(v.currentLocation);
	}
	

}
