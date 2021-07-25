package lab16;

public class Main {

	public static void main(String[] args) {
		//System.out.println(Math.PI*2*2);
		
		//Math.random(), random number between 5 - 20;
		int rand = (int)(Math.random() * 16); 
		int rand1 = (int)(Math.random() * 16) + 5;
		
		//You try: Random int between 27 and 51
		int rand2 = (int)(Math.random() * (51 - 27 + 1)) + 27;
		
		//Math.min()
		System.out.println(Math.min(4,  7));	
		
		
		System.out.println("Math.E = " + Math.E);
		System.out.println("MathClass.E = " + MathClass.E);
		System.out.println("Math.PI = " + Math.PI);
		System.out.println("MathClass.PI = " + MathClass.PI);
		MathClass m = new MathClass();
		// You can access static variables through objects and class.
		// But you cannot access nonstatic variables through the class.
		System.out.println("m.E = " + m.E);
		System.out.println("m.PI = " + m.PI);
		
		
		
		System.out.println("Math.abs(4.0) = " + Math.abs(4.0));
		System.out.println("MathClass.abs(4.0) = " + MathClass.abs(4.0));
		System.out.println("Math.abs(4) = " + Math.abs(4));
		System.out.println("MathClass.abs(4) = " + MathClass.abs(4));

		MathClass m2 = new MathClass();
		System.out.println("m2.absNS(4.0) = " + m2.absNS(4.0));
		System.out.println("m2.abs(4.0) = " + m2.abs(4.0));
		System.out.println("m2.absNS(4) = " + m2.absNS(4));
		System.out.println("m2.abs(4) = " + m2.abs(4));
		
		for(int i = 0; i < 101; i++) {
			System.out.println("sqrtNS for  " + i + ": " + m.sqrtNS(i)); // prints out the square root int from 0-100
		}
		// Illegal way: 
		// System.out.println(MathClass.sqrtNS(100));

		// Calling nonstatic methods from the class is illegal. 
		// What are the 2 illegal method calls to absNS()?
		//The 2 illegal method calls to absNS() are System.out.println("m2.absNS(4.0) = " + m2.absNS(4.0)); 
		//and System.out.println("m2.absNS(4) = " + m2.absNS(4));.

		
		MathClass m3 = new MathClass();
		for(int i=0; i<10; i++)
		    System.out.println("m3.sqrtNS(" + i + ") = " + m3.sqrtNS(i));
		// Guess what this will print out before running:
		System.out.println("MathClass.getCount() = " + MathClass.getCount());
		System.out.println("m3.getCount() = " + m3.getCount());
	}
	
	//Create a function minOf 3(double a, double b, double c) that return the smallest of three numbers
	public static double minOf3(double a, double b, double c) {
	return (Math.min(Math.min(a, b), c));
	}
	
}
