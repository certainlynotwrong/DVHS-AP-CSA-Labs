package lab11;

public class Circle {
	public double radius, x, y; // initialize x and y coordinates and radius
	
    Circle() {
        this.radius = 1;
        this.x = 0;
        this.y = 0;
    }
	
	Circle(double r, double x1, double x2) {
		this.radius = r;
		this.x = x1;
		this.y = x2;
	}
}
