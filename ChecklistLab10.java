package mrsdstuff;

public class ChecklistLab10 {

	public static void main(String[] args) {
		Money t1 = new Money(3, 14); // initialize new Money object
		DateClass t2 = new DateClass(1, 2, 3); // initialize new DateClass object 
		Point t3 = new Point(3.14, 5.62); // initialize new Point object
	}

	public class Money {
		public int dollars; // initialize ints
		public int cents;
		public String currency;
		
		Money(int amount) {
			this.dollars = amount / 100;
			this.cents = amount % 100;
		}
		
		Money(int a1, int a2) {
			this.dollars = a1;
			this.cents = a2;
		}
		public String result; // initialize string of dollar and cent values
		
	}
	public class DateClass {
		public int day, month, year;
		DateClass(int a1, int a2, int a3) {
			this.day = a1;
			this.month = a2;
			this.year = a3;
		}
	}

	public class Point {
		public double x, y; // initialize x and y coordinates
		
		Point(double x1, double x2) {
			this.x = x1;
			this.y = x2;
		}
	}

	 public static void Obj1() {
		 Money a = new Money(3, 40); // initialize new Money object
		 System.out.println(a); // pointer
		 System.out.println(a.cents + "." + a.dollars); // actual object
	 }
	 
	 public static void Obj2() {
		 DateClass b = new DateClass(1, 2, 2003); // initialize new DateClass object
		 Money a = new Money(b.day, b.year); // initialize Money object with DateClass in dollars and cents
	 }
	 
	 public static void Obj3() {
		 Money m = new Money(4, 29); // create new Money object
		 m.cents = 20; // assign value to cents attribute with dots operators
	 }

	 public static void Obj4() {
	 	Money c = new Money(6, 90); // create new Money object
	 	System.out.println("Total amount is " + c.dollars + "." + c.cents); // print values by reading
	 	c.cents = 20; // reassign value to cents attribute with dot operator
	 }

	public static double circumference(Circle c) { // start circumference
		double pi = 3.14; // initialize pi
		double rad = c.radius; // initialize the circle's radius
		return pi * 2 * rad; // return the result
	} // end circumference

	public static Money Obj5(Money a) {
		Money abc = new Money(a.dollars, a.cents - 50); // initialize new Money object
		return abc; // return the new object
	}

	public static Money Obj6(Money a) {
		a.cents += 10; // change attribute in the Money a object
		return a; // return the changed object
	}

	public static void Obj7() {
		Circle[] circs = new Circle[9]; // initialize 9 element array of Circles
		for(int i = 0; i < 8; i++) { // traverse through the array
			double chec = 2 * i + 3; // initialize the radii
			circs[i] = new Circle(chec, 0, 0);
			System.out.println("For a circle with Radius: " + chec); // print the results
			System.out.println("Area " + circleArea(circs[i]));
			System.out.println("Circumference " + circumference(circs[i]));
		}
	}


	public static Money applyInterest(Money m, double interestRate) { // applyInterst
		 double amount = (m.dollars + 0.01 * m.cents) * (1 + interestRate * 0.01); // multiply the percentage and add
		 int dollars = (int) amount;
		 return new Money(dollars, (int) (amount * 100 - dollars * 100)); // return the result as ints
	 } // end applyInterest

	 public static void Obj8() {
	 	double t = 1.3; // initialize double
	 	int res = (int) t; // convert double to int, which rounds down
	 	System.out.println(res); // print result
	 }


	 
	 


	
	
	


}
