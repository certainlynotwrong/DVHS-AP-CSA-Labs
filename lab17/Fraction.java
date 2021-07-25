package lab17;

public class Fraction {
	// Constants (Final Static Variables)
	// Static/Class Variables
	private static int objectCount = 0; // Number of Fractions Created
	private static int methodCount = 0; // Number of times methods have been called
	// Nonstatic/Instance Variables
	private int numerator;
	private int denominator;
	// Constructors
	public Fraction() {
		objectCount++;
		numerator = 0;
		denominator = 1;		
	}
	
	public Fraction(int n, int d) {
		objectCount++;
		numerator = n;
		denominator = d;
	}
	
	public Fraction(Fraction f) {
		objectCount++;
		numerator = f.numerator;
		denominator = f.denominator;
	}
	
	// Getters/Setters
	
	public static int getObjectCount() {
		return objectCount;
	}
	
	public static int getMethodCount() {
		return methodCount;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public void setNumerator(int a) {
		numerator = a;
	}
	
	public void setDenominator(int b) {
		denominator = b;
	}
	// Static Methods
	
	public static int integerPart(Fraction f) {
		methodCount++;
		if(f.isError()) {
			return -1;
		}
		return f.numerator / f.denominator;
	}
	
	public static int abs(int a) {
		if(a < 0) {
			return a * -1; //if less than 1, multiply -1 and return the result
		} else {
			return a;
		}
	}
	
	public static Fraction min(Fraction a, Fraction b) {
		methodCount++;
		if(a.isError() && !b.isError()) { // checks if a has a denominator of 0, if so then return b
			return new Fraction(b);
		}
		if(b.isError() && !a.isError()) { // checks if b has a denominator of 0, if so then return a
			return new Fraction(a);
		}
		if(a.isError() && b.isError()) { // if both have denominators of 0, return null
			return null;
		}
		int CD = a.denominator * b.denominator; // find common denominator
		int aNumer = a.numerator * b.denominator; // find new numerator for fraction A
		int bNumer = b.numerator * a.denominator; // find new numerator for fraction B
		if(CD > 0 && aNumer <= bNumer || CD < 0 && aNumer >= bNumer) { // if the common denominator is positive and a's numerator is less than b's or if the common denominator is negative and a's numerator is greater than b's
			return new Fraction(a);
		} else {
			return new Fraction(b);
		}
	}
	
	public static Fraction max(Fraction a, Fraction b) {
		methodCount++;
		if(a.isError() && !b.isError()) { // checks if a has a denominator of 0, if so then return b
			return new Fraction(b);
		}
		if(b.isError() && !a.isError()) { // checks if b has a denominator of 0, if so then return a
			return new Fraction(a);
		}
		if(a.isError() && b.isError()) { // if both have denominators of 0, return null
			return null;
		}
		int CD = a.denominator * b.denominator; // find common denominator
		int aNumer = a.numerator * b.denominator; // find new numerator for fraction A
		int bNumer = b.numerator * a.denominator; // find new numerator for fraction B
		if(CD > 0 && aNumer >= bNumer || CD < 0 && aNumer <= bNumer) { // if the common denominator is positive and a's numerator is larger than b's or if the common denominator is negative and a's numerator is less than b's
			return new Fraction(a);
		} else {
			return new Fraction(b);
		}
	}
	
	public static Fraction sum(Fraction[] a) {
		methodCount++;
		Fraction ret = new Fraction(); // create empty fraction object
		for(int i = 0; i < a.length; i++) { // traverse length of array
			ret = ret.sum(a[i]); // sum all fractions in the array together
		}
		return ret; // return result
	}
	
	
	public static Fraction[] quadraticFormula(Fraction a, Fraction b, Fraction c) {
		methodCount++; 
		if(a.equals(new Fraction(0, 1))) {
			return null;
		}
		Fraction negativeB = new Fraction(b); // the -b
		negativeB = negativeB.product(new Fraction(-1, 1)); // the -b
		Fraction bSquare = new Fraction(b); // the b^2
		bSquare = b.product(b); // the b^2
		Fraction second = new Fraction(4, 1); // the 4ac
		second = (second.product(a)); // the 4ac
		second = second.product(c); // the 4ac
		Fraction det = bSquare.difference(second); // the b^2 - 4ac
		Fraction twoA = new Fraction(a); // the 2a
		twoA = twoA.product(new Fraction(2, 1)); // the 2a
		Fraction additionalNegB = new Fraction(negativeB);
		additionalNegB = additionalNegB.quotient(twoA);
		
		
		if(det.isPositive()) { // if the determinant is positive
			Fraction[] root = new Fraction[2]; // create 2 element return array
			root[0] = additionalNegB.sum(det.sqrt().quotient(twoA)).simplified();
			root[1] = additionalNegB.difference(det.sqrt().quotient(twoA)).simplified();
			return root;
		} else if(det.equals(new Fraction(0, 1))) { // or it is linear
			Fraction[] root = new Fraction[1]; // create 1 element return array
			root[0] = negativeB.quotient(twoA);
			return root; 
		} else {
			return null;
		}
	}
	
	public static int[] factors(int n) { 
		int number = 0; // initializes size of array
		for(int i = 2; i <= n; i++) { // starts at 2 and ends at value of int n
			if(n % i == 0) { // if when divided no remainder
				number++;
			}
		}
		int[] ret = new int[number]; // now create array size of number of factors 
		int p = 0; // initializes the position
		for(int j = 0; j <=n; j++) { 
			if(n % (j + 2) == 0) {
				ret[p] = j + 2;
				p++;
			}
		}
		return ret;
	}
	
	public static void printLinearTable(Fraction start, Fraction end, Fraction step, Fraction m, Fraction b) {
		double howMany = ((start.getNumerator() - end.getNumerator()) / (step.getNumerator() / step.getDenominator()));
		System.out.println("x" + "\t" + "y");
		for(int i = 0; i < howMany; i++) {
			double num = start.getNumerator() + i * (step.getNumerator() / step.getDenominator());
			double mx = m.getNumerator() * num;
			double y = mx + b.getNumerator();
			System.out.println(num + "\t" + y);
		}
	}
	
	
	
	
	// Nonstatic Methods
	
	public String toString() {
		methodCount++;
		if(denominator == 1) // checks if denominator is equal to 1
			return "" + numerator; // if so, only the numerator would be necessary
		else
			return numerator + "/" + denominator;
	}
	
	public String toMixedNumber() {
		methodCount++;
		if(isError()) {
			return "Error - Divide by 0";
		}
		int fracWhole = numerator / denominator; // whole number of mixed fraction
		int newNumerator = numerator % denominator; // new numerator of fractional part
		if(fracWhole == 0) {
			return this.toString(); // returns only fractional part if there is no whole number
		} else if (newNumerator == 0) { // returns whole part if it simplifies into a whole number
			return "" + fracWhole;
		} else {
			return fracWhole + " " + newNumerator + "/" + denominator; // returns mixed fraction
		}
	}
	
	public int integerPart() {
		methodCount++;
		if(isError()) {
			return 0;
		}
		return numerator / denominator; 
	}
	
	public int remainder() {
		methodCount++;
		return numerator % denominator;
	}
	
	public boolean isError() {
		methodCount++;
		return denominator == 0; // checks if the denominator is 0. If so, return true.
	}
	
	public boolean isPositive() {
		methodCount++;
		if(isError()) {
			return false;
		}
		return (numerator > 0) == (denominator > 0);
	}
	
	/*public boolean equals(Fraction f) {
		methodCount++;
		return numerator * f.denominator == f.numerator * denominator; // checks if the opposing product of numerator & denominator of fractions are equal
	}*/
	
	public boolean equals(Fraction f){
        methodCount++;
        return numerator * f.getDenominator() == f.getNumerator() * denominator;
    }
	
	public boolean isSimplified() {
		methodCount++;
		if(isError()) {
			return false;
		}
		if(numerator < 0 && denominator < 0) { // checks if both numerator and denominator are negative
			return false;
		}
		if(numerator > 0 && denominator < 0)
            return false; //Make the fraction positive
        if(numerator < 0 && denominator > 0) {
            numerator = abs(numerator);
            denominator = abs(denominator);
        }
        int j;
        if(numerator > denominator) // determines if numerator or denominator smaller and sets j equal
            j = denominator;
        else
            j = numerator;
        for(int i = 2; i <= j; i++) {
            if((numerator % i == 0) && (denominator % i == 0))
                return false; //Returns false if the numerator or denominator have a common factor
        }
		return true;
	}
	
	
	public void simplify() {
		methodCount++;
		if(isError()) {
			return;
		}
		if(denominator < 0 ) { // check if denominator is negative
			numerator = -1 * numerator; // if so move negative sign from numerator to denominator
			denominator = -1 * denominator;
		}
		if(abs(numerator) < abs(denominator)) { // if the numerator is less than the denominator
			for(int i = abs(numerator); i >=2; i--) { // divide by all factors until value of numerator
				if(numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
				}
			}
		} else if(abs(numerator) > abs(denominator)) { // if the denominator is less than the numerator
			for(int i = abs(denominator); i >=2; i--) { // divide by all values until the value of the denominator
				if(numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
				}
			}
		}
	}
	

	
	public Fraction simplified() {
		methodCount++;
		Fraction a = new Fraction(this); // create new fraction object
		a.simplify(); // call the simplify function
		return a; // returned the simplified fraction
	}
	
	public Fraction sum(Fraction a) {	
		int CD = a.denominator * this.denominator; // find common denominator
		int aNumer = a.numerator * this.denominator; // find new numerator for fraction A
		int bNumer = this.numerator * a.denominator; // find new numerator for fraction B
		Fraction ret = new Fraction(aNumer + bNumer, CD);
		return ret.simplified();
	}
	
	
	public Fraction difference(Fraction a) {
		methodCount++;
		Fraction ret = new Fraction(a); // Make copy of original argument
		ret.setNumerator(-1 * ret.numerator); // make numerator of the copied fraction negative so it can be "subtracted" with the sum function
		return sum(ret); // return result of "sum"
	}
	
	public Fraction product(Fraction a) {
		methodCount++;
		Fraction ret = new Fraction(a.numerator * numerator, a.denominator * denominator);
		return ret.simplified();
	}
	
	public Fraction quotient(Fraction a) {
		methodCount++;
		Fraction ret = new Fraction(a.denominator, a.numerator); // create new Fraction object inverse of original
		ret = product(ret); // multiply them together
		return ret.simplified();
	}
	
	public Fraction sqrt() { 
		methodCount++;
		if(isError())
			return null;
		MathClass ret = new MathClass(); // create new MathClass object
		return new Fraction(ret.sqrtNS(numerator), ret.sqrtNS(denominator)).simplified(); // returns the square rooted numerator and denominator
	}
	
	public Fraction[] partialPartialFractionDecomposition(){
        int[] factors = factors(denominator); // initialize integer array of all possible denominator factors
        Fraction[] ans = new Fraction[factors.length]; // initialize Fraction array length of number of factors
        for(int i=0; i<factors.length; i++){
            ans[i] = new Fraction(0, factors[i]);
        }
        int t = numerator; // create temporary integer equal to numerator
        for(int i=0; i<factors.length; i++){ // traverse length of factors array
            int factor = factors[i]; // set factor int equal to positioned factor in the array
            if(t - denominator/factor >= 0){ // if the numerator subtracted by the denominator divided by factor results in 0
                ans[i].setNumerator(1); // set the numerator of that fraction to 1
                t -= denominator/factor; // subtract to find remaining
            }
        }
        return ans;
    }
	
	public Fraction reciprocal() {
		methodCount++;
		Fraction ret = new Fraction(this.denominator, this.numerator);
		if(ret.numerator < 0 && ret.numerator > 0) {
			ret.numerator *= -1;
			ret.denominator *= -1;
		}
		if(ret.denominator == 0) {
			return null;
		} else {
		return ret.simplified();
		}
	}
	
	
}
