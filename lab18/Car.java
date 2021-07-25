package lab18;

public class Car extends Vehicle {
	private int doors;
	private String EngMotType;
	
	public Car() {
		doors = 0;
		EngMotType = "";
	}
	
	public Car (int numberOfSeats, int numberOfPassengers, Point currentPosition, Point destination, int topSpeed, int numberOfDoors, String engineOrMotorType) {
	    super (numberOfSeats, numberOfPassengers, currentPosition, destination, topSpeed);
	    this.doors = numberOfDoors;
	    this.EngMotType = engineOrMotorType;
	  }
	
	public void communicate() {
		System.out.println("Honk Honk!");
	}
	
	public String toString() {
		if(doors == 1) {
			return "This is a " + EngMotType + "with " + doors + " door.";
		} else {
		return "This is a " + EngMotType + " with " + doors + " doors.";
		}
	}
	
}
