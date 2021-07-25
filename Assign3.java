package mrsdstuff;

import java.util.Arrays;
import java.util.Math;

public class Assign3 {

	public static void main(String[] args) {
		int[]a= {1, 2, 3, 4};
		System.out.println(sum(a));
		System.out.println(countZero(a));
		System.out.println(countPositive(a));
		System.out.println(countNegative(a));
		printArray(a);
		System.out.println(arrayToString(a));
		System.out.println(Arrays.toString(copy(a)));
		System.out.println(Arrays.toString(bigger(a)));
		System.out.println(Arrays.toString(smaller(a)));
		System.out.println(Arrays.toString(splitDigits(1234)));
		System.out.println(combineDigits(a));
		System.out.println(replaceDigit(789123, 5, 3));
		System.out.println(replaceDigit(789123, 5, 2));
	}
	public static int sum(int [] a) { // start sum
		int rV = 0; //initiate rV and set to 0
		for(int i=0; i < a.length; i++) // goes through the length of the array
			rV = rV + a[i]; //each pass will add the index
		return rV;
	} //end sum(). Returns the sum of all elements in a. 
	
	public static int countZero(int[] a) { //start countZero
		int rV = 0; //initiate rV and set to 0
		for(int i = 0; i < a.length; i++) //goes through the length of the array
			if (a[i]==0) //checks how many times 0 exists in the array
				rV++; //increment rV every time 0 is found
		return rV;
	} //end countZero(). Returns how many times 0 appears in  a. 
	
	public static int countPositive(int[] a) { //start countPositive
		int rV = 0; //initialize rV and set to 0
		for(int i = 0; i < a.length; i++) //goes through the length of the array
			if (a[i] > 0) //if number greater than 0 exists
				rV++; //increment rV
		return rV;
	} //end countPositive
	
	public static int countNegative(int[] a) { //start countNegative
		int rV = 0; //initialize rV and set to 0
		for(int i = 0; i < a.length; i++) //goes through the length of the array
			if (a[i] < 0) //if number less than 0 exists
				rV++; //increment rV
		return rV;
	} //end countNegative
	
	public static void printArray(int [] a) { // start printArray
		System.out.print("{"); // prints a "{" but not on a new line
		for (int i = 0; i < a.length; i++) { //goes through the length of the array
			if (i > 0) { //checks if i is greater than 0
				System.out.print(", "); //prints a "," between each number in the array
			}
			System.out.print(a[i]); // prints the array
		}
		System.out.println("}"); // prints a "}" after printing the array but not on a new line
	} // end printArray
	
	public static String arrayToString(int[] a) { // arrayToString
		String returnString = "{"; // initialize returnString and add a { before the rest of the array
		int i = 0; // initialize i and set it to 0
	while (i < a.length) { // while i is less than fully read 'a' array,
		returnString += a[i]; //add and set equal returnString with the elements of the array
		if (i < a.length -1) // if i is less than 1 less than the length of array 1 (otherwise it will add a comma to the last element of the array)
			returnString = returnString + ", "; //add a comma between each element in the array
		i++; // increment i
	}
		return returnString = returnString + "}"; // return returnString with a "}" to close it off
	} // end arrayToString
	
	public static int[] copy(int []a) { // start copy
		int[]b = new int[a.length]; //create a new array b and set the length equal to a
		for(int i = 0; i < a.length; i++) // goes through the length of the array
		b[i] = a[i]; // makes a copy of each element at its specific position in the new array
		return b; //return b
	} //end copy

	public static int[] bigger(int []a) { //start bigger
	      a = Arrays.copyOf(a, a.length + 1); //make a copy of array a and increase its length by 1
	      a[a.length - 1] = 0; //Assign the last element of the array to be 0
	return a; //return the result of a
	} // end bigger
	
	public static int[] smaller(int[] a) { //start smaller
		a = Arrays.copyOf(a,  a.length -1); //make a copy of the array a and decease its length by 1. This effectively removes the last item from the array
		return a; // return the result of a
	} // end smaller.
	
	public static int[] splitDigits(int a) { //start splitDigits
		String choice = Integer.toString(a); //Turn the integer a into a string called choice
		int len = choice.length(); // assigns the length of the choice string into an integer, len
		int [] result = new int[len]; //creates a new array: result
		for(int i = 0; i < len; i++) { //goes through the length of the array
			char test = choice.charAt(i); //adds the chars into the array
			result[i] = Character.getNumericValue(test);//converts the char into an integer
		}
		return result; //returns the result array
		
		
	} // end splitDigits
	
    public static int combineDigits(int[] a) { // start combineDigits
        int rV = 0; // initialize rV and set equal to 0
        for (int i = 0; i <= a.length - 1; i++) { // goes through the length of the array 
            rV = 10 * rV + a[i]; //multiplies 10 to return each time the loop is run, and adds the array
        }
        return rV; //returns the result variable
    }// end combineDigits
    
    public static int replaceDigit(int number, int newDigitValue, int digitLocation) { // start replaceDigit
    	int res = 0; //initialize RESult and set equal to 0
    	double selection = Math.pow(10, digitLocation + 1); //sets a double called selection and adds 1 to the digitLocation to set the power of 10 that will be used.
    	int intselection = (int)selection; //converts the double into an integer
    	double secondSelec = Math.pow(10, digitLocation); // sets a double called secondSelec for the remainder and part of the integer right of the insertion
    		double original = (number / intselection) * intselection; // changes a number to have only 0s at and right of the insertion point
    		double remain = number % secondSelec; // mod the number and the secondSelec
    		double newer = newDigitValue * secondSelec; // multiply the number and secondSelection to determine how many zeros are right of the newDigitValue
    		double fin = original + remain + newer; // add all the results together
    		res = (int)fin; // convert the double fin into an integer
    	return res; //return the result
    } //end replaceDigit
    
    
	
}
