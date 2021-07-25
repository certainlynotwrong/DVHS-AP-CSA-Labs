package lab18;

public class Point {
	public double x, y; // initialize x and y coordinates
	
	Point() {
		this.x = 0;
		this.y = 0;
	}
	
	Point(double x1, double x2) {
		this.x = x1;
		this.y = x2;
	}
	
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	public double distance (Point p) {
		double xdiff = (this.x - p.x) * (this.x - p.x);
		double ydiff = (this.y - p.y) * (this.y - p.y);
		return Math.sqrt(xdiff + ydiff);
	}
}
