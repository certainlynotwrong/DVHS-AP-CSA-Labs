package lab11;
import java.util.math;

public class Main {

	public static void main(String[] args) {
		Circle[] circs = new Circle[9]; // initialize 9 element array of Circles
		for(int i = 0; i < 8; i++) { // traverse through the array
			double chec = 2 * i + 3; // initialize the radii
			circs[i] = new Circle(chec, 0, 0);
			System.out.println("For a circle with Radius: " + chec); // print the results
			System.out.println("Area " + circleArea(circs[i]));
			System.out.println("Circumference " + circumference(circs[i]));
		}
		
		Circle t1 = new Circle(1, 0, 0);
		Circle t2 = new Circle(1, 2, 0);
		System.out.println(isTangent(t1, t2));
		
		Circle t3 = new Circle(2, 0, 0);
		Circle t4 = new Circle(2, 1, 0);
		System.out.println(isOverlap(t3, t4));

	}
	
	public static double circleArea(Circle c) { // start circleArea
		double pi = 3.14; // initialize pi
		double rad = c.radius; // initialize the cirle's radius
		return pi * rad * rad; // return the area of the circle
	} // end circleArea
	
	public static double circumference(Circle c) { // start circumference
		double pi = 3.14; // initialize pi
		double rad = c.radius; // initialize the circle's radius
		return pi * 2 * rad; // return the result
	} // end circumference
	
	public static boolean isTangent(Circle a, Circle b) { // start isTangent
		double rad1 = a.radius; // radius of circle a
		double rad2 = b.radius;  // radius of circle b
		double distx = a.x - b.x; // distance between a and b's x-coo
		double disty = a.y - b.y; // distance between a and b's y -coo
		System.out.println(Math.sqrt(distx * distx + disty * disty));
		System.out.println(rad1 + rad2);
		if(Math.sqrt(distx * distx + disty * disty) == rad1 + rad2) { 
			//check if the distance between the center points and the sum of the radii are equal
			return true;
		} else {
			return false;
		}
	} // end isTangent
	
	public static boolean isOverlap(Circle a, Circle b) { // start isOverlap
		double rad1 = a.radius; // radius of circle a
		double rad2 = b.radius;  // radius of circle b
		double distx = a.x - b.x; // distance between a and b's x-coo
		double disty = a.y - b.y; // distance between a and b's y -coo
		if(Math.sqrt(distx * distx + disty * disty) <= rad1 + rad2) {
			//check if the distance between the center points is less than the sum of radii
			return true;
		} else {
			return false;
		}
	} // end isOverlap
	
	

}
