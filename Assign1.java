package mrsdstuff;

public class Assign1 {
			public static void main(String[] args) {
		    System.out.println(moneyToString(10, 24));
		    printSum(10, 24, 3, 90);
		    System.out.println(biggestMoney(3, 90, 1, 23, 10, 24));
		    printChangeFrom20(3, 91);
		  }
		  public static String moneyToString(int d, int c){
		    if (c<10) //if there are less than 10 cents given
		      return "$" + d + ".0" + c; //Returns full price in d and c, in which .0 is added before c
		    return "$" + d + "." +c; // Returns full price in d and c
		  }

		  
		  
		  
		  public static void printSum(int d1, int c1, int d2, int c2) { //begin printSum
			  int totalDollars = d1 + d2 + 1; //sums both dollars and 1 extra for the 100 cents for complete money, stored as totalDollars
			  int totalCents = c1 + c2 - 100; //sums both cents and subtracts 100 cents for complete money, stored as totalCents
			String actualMoney = moneyToString(totalDollars, totalCents);
			System.out.println(actualMoney);
		  } //end printSum
		  
		  
		  public static int biggestMoney(int d1, int c1, int d2, int c2, int d3, int c3) { //start biggestMoney
			  int choice1 = d1 * 100 + c1; //sums dollars and cents for d1, c1 and stored in choice1 in cents  
			  int choice2 = d2 * 100 + c2; //sums dollars and cents for d2, c2 and stored in choice2 in cents
			  int choice3 = d3 * 100 + c3; //sums dollars and cents for d3, c3 and stored in choice3 in cents
			  if (choice1 < choice2) { //compares values to see if choice1 is less than choice2
				  if (choice2 < choice3) { //compares values to see if choice2 is less than choice3
					  return 3; //returns 3 if choice3 is greater
				  } else {
					  return 2; //returns 2 if choice3 is not greater than choice2
				  }
			  } else { //statement goes here if choice2 is less than choice1
				  if (choice1 < choice3) { //compares values to see if choice1 is less than choice3
					  return 3; //returns 3 if choice3 is greater
				  } else {
					  return 1; //returns 1 if choice3 is not greater than choice1
				  }
				  }
			  } //end biggestMoney
		  public static void printChangeFrom20(int d, int c) { //start printChangeFrom20
			  int dollarsChange = 20 - d; // Subtract the amount of dollars from $20
			  int centsChange = 100 - c; // Subtract the amount of cents from 100 cents or a dollar
			  if (centsChange == 100) { // Checks if there are no cents
				  System.out.println(moneyToString(dollarsChange, centsChange - 100)); // Prints change
			  }
			  else //If there are cents
				  {
				  String actualChange = moneyToString(dollarsChange - 1, centsChange); // Subtracts 1 from the dollars to make up for the cents
				  System.out.println(actualChange); // Prints change
				  }
		  } //end printChangeFrom20
}
