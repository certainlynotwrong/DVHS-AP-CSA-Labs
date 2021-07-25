package mrsdstuff;

public class Assign2 {

	public static void main(String[] args) {
		System.out.println(onesDigit(1234));
		System.out.println(tensOnesDigit(1235));
		System.out.println(tensDigit(1234));
		System.out.println(hundredsDigit(1234));
		System.out.println(thousandsDigit(1234));
		System.out.println(countDigits(1234));
		System.out.println(countEvenDigits(1234));
		System.out.println(getDigits(12345, 3, 0));
		
	}
		public static int onesDigit(int a) { //start onesDigit
			return a % 10; //return the value using the parameter mod 10, giving the remainder on the far right	
		} //end onesDigit
		
		public static int tensOnesDigit(int a) { //start tensOnesDigit
			return a % 100; //return the value using the parameter mod 100
		} //end tensOnesDigit
		
		public static int tensDigit(int a) { // start tensDigit
			return ((a % 100) /10 ); //return value using parameter mod 10 and divide by 10
		} // end tensOnesDigit
		
		public static int hundredsDigit(int a) { //start hundredsDigit
			return ((a % 1000) / 100); //return value using parameter mod 1000 which is then divided by 100
		} //end hundredsDigit
		
		public static int thousandsDigit(int a) { //start thousandsDigit
			return (a / 1000); //return value of thousands digit by dividing by 1000. 
		} //end thousandsDigit
		
		public static int countDigits(int a) { // start countDigits
			int count = 0; // set count to start at 0
			while(a != 0) { // while a is not 0,
				a /=10; // set a = a / 10
				++count; //increment the count by 1
			}
			return count; // return result of count	
		} // end CountDigits
		
		public static int countEvenDigits(int a) { //start countEvenDigits
			int count = 0; //set count to start at 0
			while(a!= 0) { //while a is not 0,
				a /=100; //set a = a / 100
				count++; //increment the count by 1
			}
			return count; //return result of count
		} //end CountDigits
		
		public static int getDigits(int a, int biggestDigit, int smallestDigit) { // start getDigits
			int b = 10; //initializes b and sets it at 10
			int c = 1; //initializes c and sets it at 1
			for (int はい = 0; はい < biggestDigit; はい++) { //value of biggestDigit determines the number of times the for loop will run
				b *= 10; //multiply and assign: b = b * 10
			} //close the loop
			for (int はい = 0; はい < smallestDigit; はい++) { //value of smallestDigit determines the number of times the for loop will run  
				c *=10; //multiply and assign: c = c * 10
			} //close the loop
			return (a % b) / c; //returns: a mod b, then divided by c. This is found by removing b digits from the left of a, and removing c digits from the right of what is left of that
			
		}



}
		
		
		
