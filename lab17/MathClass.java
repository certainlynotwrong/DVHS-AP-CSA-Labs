package lab17;

class MathClass {
	// Constants (Final Static Variables)
	public static double E = 2.72;
	public static double PI = 3.14;
	// Static/Class Variables 
	private static int count = 0; 
		// Nonstatic/Instance Variables
		// Constructors
	public MathClass() {
	}
	
	// Getters/Setters
	public static int getCount() {
		return count;
	}
	
	// Static Methods
	public static double abs (double value) {
		count++;
		if(value < 0) { // check if value is less than 0
			return -value; // if so return negative version of that
		} else {
			return value;
		}
	}
	
	public static String abs(int value) {
		count++;
		return  "|" + value + "|";
		}
	
	// Nonstatic Methods
	public double absNS(double value) {
		count++;
		if(value >= 0) {
			return value;
		} else {
			return -value;
		}
	}
	
	public String absNS(int value) {
		count++;
		return "|" + value + "|";
	}
	
	public int sqrtNS(int value) { // start sqrtNS
		count++;
		value = (int) abs((double) value); // absolute value the given integer
		int i = 0;
		for(i = 0; i * i <= value; i++) { // increments until the square of i is equal/greater than the requested value
		}
		return i - 1; //subtract the final increment
	} //end sqrtNS
}
