package lab19;

public class Rectangle extends Shape {
	private final int NUMBER_OF_SIDES = 4;
	private double length, width;
	
	public Rectangle() {
		super(4);
		length = 0;
		width = 0;
	}
	
	public Rectangle(double l, double w) {
		super(4);
		length = 1;
		width = w;
	}
	
	public void setLength(double l) {
		length = l;
	}
	
	public void setWidth(double w) {
		width = w;
	}
	
	public int getNumberOfSides () {
		return NUMBER_OF_SIDES;
	}
	
	public double getLenth() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double perimeter() {
		return 2 * length + 2 * width;
	}
	
	public double area() {
		return length * width;
	}
	
	public String toString() {
		return "Rectangle with 4 sides, length = " + length + " and width = " + width; 
	}
}
