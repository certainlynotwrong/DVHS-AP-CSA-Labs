package lab19;

public class Triangle extends Shape{
	private final int NUMBER_OF_SIDES = 3;
	private double aside, bside, cside, base, height;
	
	public Triangle() {
		super(4);
		aside = 0;
		bside = 0;
		cside = 0;
		base = 0;
		height = 0;
	}
	
	public Triangle(double a, double b, double c, double ba, double he) {
		super(4);
		aside = a;
		bside = b;
		cside = c;
		base = ba;
		height = he;
	}
	
	public void setA(double a) {
		aside = a;
	}
	
	public void setB(double b) {
		bside = b;
	}
	
	public void setC(double c) {
		cside = c;
	}
	
	public void setBase(double ba) {
		base = ba;
	}
	
	public void setHeight(double he) {
		height = he;
	}
	
	public double getA() {
		return aside;
	}
	
	public double getB() {
		return bside;
	}
	
	public double getC() {
		return cside;
	}
	
	public double getbase() {
		return base;
	}
	
	public int getNumberOfSides () {
		return NUMBER_OF_SIDES;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double perimeter() {
		return aside + bside + base;
	}
	
	public double area() {
		return 0.5 * base * height;
	}
	
	public String toString() {
		return "Triangle with 3 sides, sides lengths = " + aside + "," + bside + "," + "," + cside + " base = " + base + ", height = " + height; 
	}
}
