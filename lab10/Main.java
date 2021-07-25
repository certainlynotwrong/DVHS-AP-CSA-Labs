package lab10;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Money t1 = new Money(2900);
		System.out.println(moneyToString(t1));
		Money t2 = new Money(301);
		System.out.println(moneyToString(add(t1, t2)));
		System.out.println(moneyToString(payWith20(t2)));
		Money t3 = new Money(1000);
		System.out.println(moneyToString(applyInterest(t1, 1)));
		testCodeMoney();
		System.out.println("");
		Point te1 = new Point(1, 2);
		System.out.println(pointToString(te1));
		Point te2 = new Point(0, 0);
		System.out.println(pointToString(midpoint(te1, te2)));
		System.out.println(isEqual(te1, te2));
		System.out.println(quadrant(te1));
		verticalStretch(te1, 3);
		Point te3 = new Point(1, 2);
		horizontalStretch(te3, 3);
		Point te4 = new Point(1, 2);
		verticalShift(te4, -3);
		testCodePoint();
	}
	 public static String moneyToString(Money m) { // start moneyToString
		String ret = "$"; // initialize return string 
		int dollars = m.dollars; // initialize money integer value
		int cents = m.cents;
		ret += dollars; // convert the dollars into a string
		ret += "."; // add a period between dollars and cents
		if(cents < 10) { // if there are less than 10 cents
			ret += "0" + cents; // add a 0 before the amount of cents
		} else {
			ret += cents;
		}
		return ret; // return resulting string
	} // end moneyToString
	 
	 public static Money add(Money m1, Money m2) { // start add
		 int dolltotal;
		 dolltotal = m1.dollars + m2.dollars;
		 int centtotal;
		 centtotal = m1.cents + m2.cents;
		 if(centtotal > 99) {
			 dolltotal = dolltotal + centtotal / 100;
			 centtotal = centtotal % 100;
		 }
		 return new Money(dolltotal, centtotal);
	 } // end add
	 
	 public static Money payWith20(Money m) { // start payWith20
		  int dollars = 19 - m.dollars; // find the change for dollars
		  int cents = 100 - m.cents; // find change for cents
		  return new Money(dollars, cents); // return the result
	 } // end payWith20
	 
	 public static Money applyInterest(Money m, double interestRate) { // applyInterst
		 double amount = (m.dollars + 0.01 * m.cents) * (1 + interestRate * 0.01); // multiply the percentage and add
		 int dollars = (int) amount;
		 return new Money(dollars, (int) (amount * 100 - dollars * 100)); // return the result as ints
	 } // end applyInterest

	 
	 public static void testCodeMoney() { // start testCodeMoney
		 double sum = 0;// initialize result of sum
		 Money[] obj = new Money[100]; // Initialize 100 element Money array
		 for(int i = 0; i < 99; i++) { // traverse the length of the array
			 obj[i] = new Money(0, i + 1); // add cents to every element except the last one
		 }
		 obj[99] = new Money(1, 0); // add a dollar to the last element
		 for(int j = 0; j < 99; j++) {// traverse the length of the array
			 sum = sum + obj[j].cents; // add up all the cents
		 }
		 sum = obj[99].dollars + sum / 100; // add up the dollars and the cents
		 System.out.println("Total amount is: $" + sum + "0"); // print out the result
		 
		 
		 Money monthly = new Money(10, 0);
		 Money twentyeight = new Money(monthly.dollars * 28, 0);
		 Money twentynine = new Money(monthly.dollars * 29, 0);
		 Money thirty = new Money(monthly.dollars * 30, 0);
		 Money thirtyone= new Money(monthly.dollars * 31, 0);
		 Money t8 = applyInterest(twentyeight, 1);
		 Money t9 = applyInterest(twentynine, 1);
		 Money t30 = applyInterest(thirty, 1);
		 Money t31 = applyInterest(thirtyone, 1);
		 System.out.println(moneyToString(t8));
		 System.out.println(moneyToString(t9));
		 System.out.println(moneyToString(t30));
		 System.out.println(moneyToString(t31));

		 Random yr = new Random(); // initialize new random for year
		 int year = yr.nextInt(2100) + 1900; // random year between 1900 - 3000
		 if(year % 4 == 0) { // if leap year
			 System.out.println("It is a leap year: " + year); // print out the year and what type
			 Money t1 = new Money(t9.dollars + t30.dollars * 4 + t31.dollars * 7, // sum up the saved amount
					 t9.cents + t30.cents * 4 + t31.cents * 7);
			 if (t1.cents >= 100) { // write it in the conventional dollars.cents format
				 t1.dollars = t1.dollars + (t1.cents / 100);
				 t1.cents = t1.cents % 100;
			 }
			 System.out.println(moneyToString(t1)); // print resulting string
			 
		 } else { // if standard year
			 System.out.println("It is a standard year: " + year);
			 Money t1 = new Money(t8.dollars + t30.dollars * 4 + t31.dollars * 7, 
					 t8.cents + t30.cents * 4 + t31.cents * 7);
			 if (t1.cents >= 100) {
				 t1.dollars = t1.dollars + (t1.cents / 100);
				 t1.cents = t1.cents % 100;
			 }
			 System.out.println(moneyToString(t1));
		 } // end
		 
		 
		 String[]shoppingList = {" Orange Juice, Campbells Soup, Oreos, Bagels, Bananas"}; // list of Safeway goods
		 Money[]shoppingPrices = new Money[5]; // Initialize new Money array
		 shoppingPrices[0] = new Money(3, 99); // fill array with prices of goods
		 shoppingPrices[1] = new Money(2, 98);
		 shoppingPrices[2] = new Money(4, 29);
		 shoppingPrices[3] = new Money(3, 49);
		 shoppingPrices[4] = new Money(0, 64);
		 Money totalprice = new Money(0, 0);
		 for(int i = 0; i < 5; i++) { // traverse length of array
			 totalprice = add(totalprice, shoppingPrices[i]); // sum the prices
		 } 
		 totalprice = applyInterest(totalprice, 8.25); // Calculate the result after sales tax
		 totalprice = payWith20(totalprice); // calculate change
		 System.out.println("The change from buying" + shoppingList[0] + " is " + moneyToString(totalprice)); // print items and change
		  // end

	       
	 }
	 
	 public static String pointToString(Point p) { // start pointToString
		 String ret = "("; // initialize return string
		 double xval = p.x; // initialize double
		 double yval = p.y;
		 ret += xval + ", " + yval + ")"; // concatenate values into string
		 return ret; // return string
	 } // end pointToString
	 
	 public static Point midpoint(Point p1, Point p2) { // start midpoint
		 double xval = (p1.x + p2.x) / 2; // find x of midpoint
		 double yval = (p1.y + p2.y) / 2;  // find y of midpoint
		 return new Point(xval, yval); // return the midpoint
	 } // end midpoint
	 
	 public static boolean isEqual(Point p1, Point p2) { // start isEqual
		 if(p1.x == p2.x && p1.y == p2.y) { // compare x and y values
			 return true; // if the same, return true
		 } else {
			 return false; // if not the same, return false
		 }
	 } // end isEqual
	 
	 public static int quadrant(Point p) { // start quadrant
		 double xval = p.x; // initialize x coordinate
		 double yval = p.y; // initialize y coordinate
		 if(xval > 0 && yval > 0) { // check the quadrant
			 return 1;
		 } else if (xval < 0 && yval > 0) {
			 return 2;
		 } else if (xval < 0 && yval < 0) {
			 return 3;
		 } else {
			 return 4;
		 }
	 } // end quadrant
	 
	 public static void verticalStretch(Point p, double a) { // start verticalStretch
		 p.x = p.x;
		 p.y = p.y * a; // multiply to y-coordinate
	 } // end verticalStretch
	 
	 public static void horizontalStretch(Point p, double a) { // start horizontalStretch
		 p.x = p.x * a; // multiply to x-coordinate
		 p.y = p.y;
	 } // end horizontalStretch
	 
	 public static void verticalShift(Point p, double a) { // start verticalShift
		 p.x = p.x;
		 p.y = p.y + a; // add/subtract to y value
	 } // end verticalShift
	 
	 public static void horizontalShift(Point p, double a) { // start horizontalShift
		 p.x = p.x + a; // add/subtract to x value
		 p.y = p.y;
	 } // end horizontalShift
	 
	 
	 public static void testCodePoint() {
		 Point[] a = new Point[5]; // Initialize new point array
		 for(int i = 0; i < 5; i++) { // traverse length of array
			 a[i] = new Point((i * 2) + 2, 2 * ((i * 2) + 2) + 3); // define the points
			 System.out.println(pointToString(a[i]));
		 } // end
		
		 System.out.println("\n" + "Vertical Stretch by 3:");
		 for(int b = 0; b < 5; b ++) { // traverse length of array
			 verticalStretch(a[b], 3); // apply vertical stretch to all points
			 System.out.println(pointToString(a[b])); // print results
		 } // end
		 
		 System.out.println("\n" + "Horizontal Stretch by 2:");
		 for(int c = 0; c < 5; c++) { // traverse length of array
			 horizontalStretch(a[c], 2); // apply horizontal stretch to all points
			 System.out.println(pointToString(a[c])); // print results
		 } // end
		 
		 System.out.println("\n" + "Vertical Shift down by 1:");
		 for(int i = 0; i < 5; i++) { // traverse length of array
			 verticalShift(a[i], -1); // apply vertical shift left 1 to all points
			 System.out.println(pointToString(a[i])); // print results
		 } // end
		 
		 System.out.println("\n" + "Horizontal Shift right by 2:");
		 for(int i = 0; i < 5; i++) { // traverse length of the array
			 horizontalShift(a[i], 2); // apply horizontal shift right by 2 to all points
			 System.out.println(pointToString(a[i])); // print results
		 } // end
		 
		 System.out.println("");
		 Point[] sin = new Point[5]; // initialize sin array
		 double pi = 3.14;
		 sin[0] = new Point(0, 0); // create points
		 sin[1] = new Point(0.5 * pi, 1);
		 sin[2] = new Point(pi, 0);
		 sin[3] = new Point(1.5 * pi, -1);
		 sin[4] = new Point(2 * pi, 0);
		 
		 for(int i = 0; i < 5; i++) {
		 System.out.println(pointToString(sin[i])); 
		 }
		 
		 System.out.println("\n" + "Vertical shift by 2, then a stretch by 2");
		 for(int j = 0; j < 5; j++) { // start vert shift by 2 & stretch by 2
			 verticalShift(sin[j], 2);
		 }
		 for(int j = 0; j < 5; j++) {
			 verticalStretch(sin[j], 2);
			 System.out.println(pointToString(sin[j]));
		 }
		 
		 System.out.println("\n" + "Vertical stretch by 2, then a shift by 2");
		 for(int j = 0; j < 5; j++) { // start vert strech by 2 & shift by 2
			 verticalStretch(sin[j], 2);
		 }
		 for(int j = 0; j < 5; j++) {
			 verticalShift(sin[j], 2);
			 System.out.println(pointToString(sin[j]));
		 } 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	
	

}
