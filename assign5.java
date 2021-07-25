package mrsdstuff;
import java.util.Arrays;
public class assign5 {


	public static void main(String[] args) {
		System.out.println(Arrays.toString(createMoney(6, 345)));
		int []money = {15, 1};
		System.out.println(Arrays.toString(copyMoney(money)));
		System.out.println(dollars(money));
		System.out.println(cents(money));
		int []mS = {2, 0};
		System.out.println(moneyToString(mS));
		int []ts = {458, 5};
		System.out.println(moneyToText(ts));
		int []m1 = {488};
		int []m2 = {458};
		System.out.println(isGreaterThan(m1, m2));
		System.out.println(isEqual(m1, m2));
		int []m3 = {3, 20};
		int []m4 = {4, 25};
		adder(m3, m4);
		int []m5 = {3, 20};
		int []m6 = {4, 25};
		System.out.println(Arrays.toString(add(m5, m6)));
		int []m7 = {4, 26};
		int []m8 = {3, 25};
		subber(m7, m8);
		int []m9 = {4, 24};
		int []m10 = {3, 25};
		System.out.println(Arrays.toString(sub(m9, m10)));
		int []m11 = {3, 91};
		System.out.println(Arrays.toString(payWith20(m11)));
		
		assign5 test14 = new assign5(); 
		int []m12 = {3, 25};
		test14.applyInterest(m12, 5);
		int []bruh = {5, 12};
		something(bruh);
		
		
	}
	public static int[] createMoney(int dollars, int cents) { // start CreateMoney
		int a[] = new int[2]; // initialize new array of size 2
		if (cents <= 99) { // if the number of cents is less than or equal to 99
			a[0] = dollars; // assign the first element of the new array to be dollars
			a[1] = cents; // assign the second element of the new array to be cents
			return a;
			}	
		else // or if cents is 100 or more
			// add the dollars to the number of cents divided by 100, which is 
			//essentially a conversion of cents to dollars.
			dollars += (cents / 100);  
			cents %= 100; // find how many cents are left after dividing by 100
			a[0] = dollars; // assign the first element of the new array to be dollars
			a[1] = cents; // assign the second element of the new array to be cents
			return a;
	} // end CreateMoney
	public static int[] copyMoney(int[] money) { // start copyMoney
		int a[] = new int[money.length]; // initialize a new array the length of the money array
		for(int i = 0; i < money.length; i++) { // goes through the length of money
			// set the element at any position in a to be the same element in 
			//the same position in money array.
			a[i] = money[i];
		}
		return a;
    } // end copyMoney
	public static int dollars(int[] money) { // start dollars
		return money[0]; // return the first element in the array	
	} // end dollars
	public static int cents(int[] money) { // start cents
		return money[1]; // return the second element in the array
	} // end dollars
	public static String moneyToString(int[] money) { // start moneyToString
		if (money[1] < 10) { // if there are less than 10 cents
			//convert the first element in the array to a string
			String fD = String.valueOf(money[0]); 
			//convert the second element in the array to a string
			String sD = String.valueOf(money[1]); 
			// return the dollar symbol, the dollar amount, a leading zero for 
			//cents, and finally cents
			return "$" + fD + ".0" +sD;
		}
		else { // or if there ar3 10 cents or more
		//convert the first element in the array to a string
		String fD = String.valueOf(money[0]);
		//convert the second element in the array to a string
		String sD = String.valueOf(money[1]);
		//return the dollar symbol, the dollar amount, and the cents amount
		return "$" + fD + "." + sD;
		}
	} // end moneyToString
	public static String moneyToText(int[] money) { //moneyToText
		String numtoword = ""; //initialize an empty string
		// create String array of all the ones digits, as well as -teens
		String units[] = {"zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
				" fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		// create String array of all the tens digits
		String tens[] = {"zero", "ten", "twenty", "thirty", "fourty", "fifty", 
				"sixty", "seventy", "eighty", "ninety"};
		if (money[1] == 0) { // if there are no cents
			if ((money[0] / 100) > 0) { // if there are more than 100 dollars
				// add the result of the division and the word hundred to the string
				numtoword += units[money[0] / 100] + " hundred and "; 
				money[0] %= 100; // find how many dollars remain
			}
				if (money[0] < 20) { // if there are less than $20
					numtoword += units[money[0]] + " dollars"; // add the number of dollars to the word "dollars"
				} else { // if there are more than $20
					numtoword += tens[money[0] / 10]; // add the number of dollars divided by 10 to the string
					if ((money[0] % 10) > 0) { // if there are dollars in the units place
						numtoword += " " + units[money[0] % 10] + " dollars"; //add the number of remaining dollars in units place and "dollars"
					}
				}
			}
		if (money[1] > 0) { // if there are cents
			if ((money[0] / 100) > 0) { // if there are more than 100 dollars
				numtoword += units[money[0] / 100] + " hundred and "; // add the result of the division and the word hundred to the string
				money[0] %= 100; // find how many dollars remain
			}
				if (money[0] < 20) { // if there are less than $20
					if (money[1] < 20) { // if there are less than 20 cents
						// add the number of dollars in units to cents in units to the empty string
						numtoword += units[money[0]] +  " dollars and " + units[money[1]] + " cents"; 
					}
					else { // if there are more than 20 cents
						if ((money[1] % 10) > 0) { // if there are cents in the unit place
							// add the number of dollars in units, tens, and cents in to the string
							numtoword += units[money[0]] + " dollars and " + 
							tens[money[1] / 10] + " " + units[money[1] % 10] + " cents";
						}
					}
				} else { // if there are more than $20
					if (money[1] < 20) { // if there are less than 20 cents
						numtoword += tens[money[0] / 10]; // add the number of dollars divided by 10 to the string
						if ((money[0] % 10) > 0) { // if there are dollars in the units place
							// add the number of dollars in units and cents to the string
							numtoword += " " + units[money[0] % 10] + " dollars and " + 
							units[money[1]] + " cents";
						}
						} else { // if there are more than 20 cents
						numtoword += tens[money[0] / 10]; // add the number of tens of dollars to the string
						if ((money[0] % 10) > 0) { // if there are are dollars in the unit place
							// add the number of dollars in units, tens, and cents to the string
							numtoword += " " + units[money[0] % 10] + " dollars and " +
							tens[money[1] / 10] + " " + units[money[1] % 10] + " cents";
						}
					}
		}
		
	}
		return numtoword;
	} // end moneyToText
	
	public static boolean isGreaterThan(int[] m1, int[] m2) { // start is GreaterThan
		if (m1[0] > m2[0]) { // checks if first element of the m1 array is greater than the first element of m2 array
			return true; // if so, return true
		}
		else //if not return false
			return false;		
	} // end isGreaterThan
	public static boolean isEqual(int[]m1, int[] m2) { //start isEqual
		if (m1[0] == m2[0]) { //checks if the first element of the m1 array is greater than the first element of m2 array
			return true; // if so, return true
		}
		else
			return false; // if not return false
	} // end isEqual
	public static void adder(int[] m1, int[] m2)  { // start adder 
		if (m1[1] + m2[1] > 99) { // if there are more than 99 cents
			m1[0] += 1 + m2[0];  // add one to the sum of the dollars to carry over
			m1[1] = (m1[1] + m2[1]) % 100; // find how many cents are left after adding them together and removing the extra dollars
		} else { // if thre are less than 99 cents
			m1[0] += m2[0]; // add the dollars together
			m1[1] += m2[1]; // add the cents together 
		}
		System.out.println(Arrays.toString(m1));
	} // end adder
	public static int[] add(int[] m1, int[] m2) { // start add
		int dollars = m1[0] + m2[0]; // initialize integer to be equal to the sum of the dollars
		int cents = m1[1] + m2[1]; // initialize integer to be equal to hte sum of the cents
		if (cents > 99) { // if there are more than 99 cents
			cents %= 100; // find out how many cents remain after taking out the extra dollars
			dollars += cents/100; // add however many extra cents as dollars to dollars
		} else { // if there are less than 99 cents
			cents +=0; // keep cents the same
			dollars +=0; // keep dollars the same
		}
		int[] rI = new int[2]; //initialize a new array with a length of 2
		rI[0] = dollars; // set the dollars to be the first element
		rI[1] = cents; // set the cents to be the second element
		return rI; //return the array
	} // end add
	public static void subber(int[] m1, int[] m2) { // start subber
		if (m1[1] - m2[1] < 0) { // if there are less cents in the first amount than the second
			m1[1] = (100 + m1[1]) - m2[1]; // add 100 to the cents in the first amount and subtract the second amount
			m1[0] = m1[0] - 1 - m2[0]; // subtract 1 and the second dollars from the first dollars because cents were carried over
		} else { // if there are more cents in the first amount than the second amount
			m1[0] -= m2[0]; // subtract the second dollars from the first dollars
			m1[1] -= m2[1]; // subtract the second cents from the first cents
		}
		System.out.println(Arrays.toString(m1));
	} // end subber
	public static int[] sub(int[] m1, int[] m2) { // start sub
		int dollars = m1[0] - m2[0]; // intitialize integer to be equal to the difference in dollars
		int cents = m1[1] - m2[1]; // initialize integer to be equal to the difference in cents
		if (cents < 0) { // if there are less cents in the first amount than the second
			cents += 100; //add 100 to the difference in cents
			dollars -= 1; // subtract 1 from the toal dollars
		} else { // if there are more cents in the first amount than the second
			cents +=0; // keep cents the same
			dollars +=0; // keep dollars the same
		}
		int[] rI = new int[2]; // initialize a new array with a length of 2
		rI[0] = dollars; // set the dollars to be the first element
		rI[1] = cents; // set the cents to be the second element
		return rI; // return the array
	} // end sub
	public static int[] payWith20(int[] owe) { // start owe
		int dollars = 20; // initialize the number of dollars and set to $20
		int cents = 100; // initialize the cents and set equal to to 100
		dollars -= owe[0] + 1; // subtract the dollars and and add 1
		cents -= owe[1]; // subtract the cents
		int [] rI = new int[2]; // initialize a new 2 element array 
		rI[0] = dollars; // set the dollars to be the first element
		rI[1] = cents; // set the cents to be the second element
		return rI; // return the array 
	} // end owe
	public int[] applyInterest(int[] balance, int interest) { // start applyInterest
		int balance_v = (balance[0] * 100) + balance[1]; // initialize integer equal to the product of dollars and 100 and add the cents
		int subamount = balance_v * interest; // initialize integer equal to that result multplied to the interest
		int dollars = subamount / 100000; // divide by 10,000 to get dollars
		int cents = (subamount % 100000); // mod by 10,000 to get cents
		int new_cents = (cents / 100); // divide that cents amount by 100 to get the true amount of cents and to round
		int[] result  = new int[2]; // initialize a new array array of length 2
		result[0] = dollars; // set the dollars to be the first amount
		result[1] = new_cents; // set the cents to be the second amount
		if(balance[1] + result[1] > 99) { // if there are more than 99 cents
			balance[0] += result[0] + 1; // carry over by adding 1 to the dollars
			balance[1] = balance[1] + result[1] - 100; // subtract the carried over dollar from the cents
		} else { // if there are less than 99 cents
			balance[0] += result[0]; // move the resulting dollars to the new array
			balance[1] += result[1]; // move the resulting cents to the new array
		}
		System.out.println(Arrays.toString(balance));
		return balance; // return the array
	} // end applyInterest
	
	public static int[] something(int[] balance) {
		int yer_tim = 12;
		int inside = 11;
		for (int i = 0; i < yer_tim; i ++) {
			inside *= i;
		}
		int act_resu = inside / (10 * 10 * 10 * 10 *10 *10 *10 * 10 * 10 *10 *10 *10);
		int[] result  = new int[2];
		result[0] = act_resu * balance[0];
		result[1] = act_resu * balance[1];
		if (result[1] > 99) {
			result[1] %= 100;
			result[0] += balance[1] / 100;
		} else {
			result[0]+=0;
			result[1]+=1;
		}
		return result;
		
	}
	
}
