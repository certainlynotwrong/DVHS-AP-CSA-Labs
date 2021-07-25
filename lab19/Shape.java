package lab19;
import java.util.Scanner;
import java.util.Arrays;

public class Shape {

	private final int NUMBER_OF_SIDES;
	
	public Shape() {
		NUMBER_OF_SIDES = 0;
	}
	
	public Shape(int num) {
		NUMBER_OF_SIDES = num;
	}
	
	//Getter
	public int getNUMBER_OF_SIDES() {
		return NUMBER_OF_SIDES;
	}
	
	public double area() {
		return 0;
	}
	
	public double perimeter() {
		return 0;
	}
	
}
