package lab19;

public class Circles extends Shape{
	private final int NUMBER_OF_SIDES = 1;
	private double radius;
	private Point center;
	
	public Circles() {
		super(2);
		radius = 0;
		center = new Point(0, 0);
	}
	
	public Circles(double r, Point c) {
		super(2);
		radius = r;
		center = c;
	}
	
	public void setRadius(double r) {
		radius = r;
	}
	
	public void setPoint(Point p) {
		center = p;
	}
	
	public int getNumberOfSides () {
		return NUMBER_OF_SIDES;
		}

	
	public double getRadius() {
		return radius;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public double area() {
		return Math.PI * radius * radius;
	}
	
	public String toString() {
		return "Circle with 1 side, radius = " + radius + " and center " + center.toString(); 
	}


}
