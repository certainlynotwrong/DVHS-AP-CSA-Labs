package mrsdstuff;

import java.util.Arrays;

public class Assign6 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(createStack()));
		int [] bruh = createStack();
		push(bruh, 1);
		push(bruh, 2);
		push(bruh, 3);
		pop(bruh);
		System.out.println(Arrays.toString(bruh));
		System.out.println(prettyPrintStack(bruh));
		System.out.println(dumpStack(bruh));
		int[] at = {2, 42, 69};
		int[] bt = {2, 30000, 40000};
		printReportFILO(at, bt);
		System.out.println(runReportFILO(at, bt));
		int[] ct = new int[2];
		int[] dt = new int[2];
		buyFILO(ct, dt, 5, 5000);
		System.out.println(sellFILO(at, bt, 6, 9000));
		System.out.println(averageFILO(at, bt));
		int [] bru = createQueue();
		enqueue(bru, 69);
		enqueue(bru, 420);
		System.out.println(Arrays.toString(bru));
		enqueue(bru, 15);
		System.out.println(Arrays.toString(bru));
		System.out.println(dequeue(bru));
		System.out.println(dequeue(bru));
		task5();
		int[] a = new int[3];
		int[] b = new int[3];


		System.out.println(Arrays.toString(merge(a, b)));
	}
	
	public static int[] createStack() {  // start createStack
		int[] stack = new int[101]; // Create new array of 101 integers
		return stack; // return the created array
	} // end createStack
	
	public static void push(int[] stack, int data) { // start push		
		stack[stack[0] + 1] = data; // Set data equal to the next value in the stack
		stack[0]++; // increment the first element in the array to display the number of values in the stack
	} // end push
	
	public static void pop(int[] stack) { // start pop
		stack[stack[0]] = 0; // Remove the last value in the stack by changing it to 0
		stack[0]--; // decrement the first element in the array to display the number of values in the stack
	}
	
	public static String prettyPrintStack(int[] stack) { // start prettyPrintStack
		String str = "["; // begin the string with a [
		for(int i = 1; i < stack[1] + stack[0]; i++ ) { // run through array with the number of terms in the array
			str += stack[i]; // add each element in the array into the string
			if(i < stack[0]) 
			str += ","; //insert a comma to separate each element if it is not the last one
		}
		str += "]";
		return str;
	} // end prettyPrintStack
	
	public static String dumpStack(int[] stack) { // start dumpStack
		String str = "{"; // begin the string with a {
		for(int i = 0; i < stack.length; i++) { // run through the length of the array
			str += stack[i]; // add each element in the array into the string
			if(i < 100)
			str += ", "; // insert a comma to separate each element if it is not the last one
		}
		str += "}"; // end the string with a }
		return str; // return the string
	} // end dumpStack
	
	public static void task2() { // start task2
		int[] original = createStack(); // create new array and calls createStack function
		push(original, 9); // push 9
		push(original, 8); // push 8
		push(original, 7); // push 7
		push(original, 6); // push 6
		push(original, 5); // push 5
		push(original, 4); // push 4
		push(original, 3); // push 3
		pop(original); // pop once
		pop(original); // pop again
		pop(original); // pop the third time
		push(original, 1); // push 1
		push(original, 2); // push 2
		push(original, 3); // push 3
		push(original, 4); // push 4
		pop(original); // pop once
		pop(original); // pop again
		pop(original); // pop the third time
		pop(original); // pop the fourth time
		pop(original); // pop the fourth time
		System.out.println(prettyPrintStack(original)); // calls prettyPrintStack
	} // end task2
	
	public static void printReportFILO(int[] shares, int[] price) { // start printReportFILO
		System.out.println("Shares \t Price"); // print out header row
		int dollars; // initialize cents
		int cents; // initialize dollars
		String moneyA = ""; // initialize empty string
		for (int i = 1; i < shares[0] + 1; i++) { // runs through the value of the first element of shares array added to one
			dollars = price[i] / 100; // find the number of dollars
			cents = price[i] % 100; // find the number of cents
			if (cents <= 9) { // if there are less than 10 cents
				moneyA = "$" + dollars + ".0" + cents; // add a 0 before the cents
		}
			else {
				moneyA = "$" + dollars + "." + cents;
			}
		System.out.println(shares[i] + "\t" + moneyA); // print into the row
		}
	} // end printReportFILO
	
	public static String runReportFILO(int[] shares, int[] price) { // start runReportFILO
		String start = "Shares \t Price"; // initialize header row string
		int dollars; // initialize dollars
		int cents; // initialize cents
		String moneyA = ""; // initialize blank string
		for (int i = 1; i < shares[0] + 1; i++) { // runs through the value of the first element of shares array added to one
			dollars = price[i] / 100; // find number of dollars
			cents = price[i] % 100; // find the number of cents
			if (cents <= 9) { // if there are less than 10 cents
				moneyA = "$" + dollars + ".0" + cents; // add a 0 before the cents
		}
			else {
				moneyA = "$" + dollars + "." + cents;
			}
			start += "\n" + shares[i] + "\t" + moneyA; // concatenate the values into the string
		}
		return start; // return the string
	} // end runReportFILO
	
	public static void buyFILO(int[] shares, int[] price, int numShares, int pricePerShare) { // start buyFILO
		push(shares, numShares); // initialize push function to put numShares into shares array
		push(price, pricePerShare); // initialize push function to put pricePerShare into shares array
		printReportFILO(shares, price); // initialize printReportFILO to add to shares and price, but this isn't necessary
	} // end buyFILO
	
	public static int sellFILO(int[] shares, int[] price, int numShares, int pricePerShare) {
		int numberShares = 0; // initialize price of shares
		int sum; // initialize sum
		int sharexprice = 0; // initialize how many shares
		for(int i = 1; i < shares[0] + 1; i++) { // run through the length of the shares array
			sum = shares[i] * price[i]; // multiply the shares by their price
			numberShares += sum; // add to the total price of all the shares
		}
		for(int i = 1; i < shares[0] + 1; i++) { // run through the length of the shares array
			sharexprice = shares[i] + sharexprice; // find how many shares were purchased
		}
		int howmuch = numShares * pricePerShare; // find how much the stocks being sold are in total
		int fin = howmuch - sharexprice; // subtract the that amount from the total price of the original stock
		return fin; // return the amount in cents
	} // end sellFILO
	
	public static int averageFILO(int[] shares, int[] price) { // start averageFILO
		int numberShares = 0; // initialize price of shares
		int sum; // initialize sum
		int sharexprice = 0; // initialize how many shares
		for(int i = 1; i < shares[0] + 1; i++) { // run through the length of the shares array
			sum = shares[i] * price[i]; // multiply the shares by their price
			numberShares += sum; // add to the total price of all the shares
		}
		for(int i = 1; i < shares[0] + 1; i++) { // run through the length of the shares array
			sharexprice = shares[i] + sharexprice; // find how many shares were purchased
		}
		if((numberShares * 100 / sharexprice) >= 5) { // check rounding condition
			int fin = (numberShares / sharexprice) + 1; // integer of average share
			return fin; // return integer
		}
		else {
			int fin = (numberShares / sharexprice); // integer of average share
			return fin; // return integer
		}
	} // end averageFILO
	
	public static int[] createQueue() { // start createQueue
		int[] newQ = new int[101]; // create new array of 101 integers
		return newQ; // return the array
	} // end createQueue
	
	public static void enqueue(int[] queue, int data) { // start enqueue
		queue[queue[0] + 1] = data; // Set data equal to the next value in the queue
		queue[0]++; // increment the first element in the array to display the number of values in the queue
	} // end enqueue
	
	public static int dequeue(int[] queue) { // start dequeue 
		queue[0]--; // decrement number of terms in queue by one
		for(int i = 1; i <= queue[0]; i++) { // runs until the number of elements in the stack
			queue[i] = queue[i + 1]; // Shift all elements to the left by one
		}
		return queue[1]; // return the dequeued number
	} // end dequeue
	
	public static String prettyPrintQueue(int[] queue) { // start prettyPrintQueue
		String str = "["; // begin string with a [
		for(int i = 1; i < queue[0] + 1; i ++) { // run through the queue of the number of elements in it
			str += queue[i]; // add each element to the string
			if(i < queue[0])
				str+= ","; // insert a comma to separate each element if it is not the last one
		}
		str += "]";
		return str; // return the final string
	} // end prettyPrintQueue
	
	public static String dumpQueue(int[] queue) { // start dumpQueue
		String str = "{"; // begin string with a {
		for(int i = 0; i < queue[0] + 1; i ++) { // run through the queue of the number of elements in it
			str += queue[i]; // add each element to the string
			if(i < 100)
				str += ","; // insert a comma to separate each element if it is not the last one
		}
		str += "}";
		return str; // return the final string
	} // end dumpQueue
	
	public static void task5() { // start task5
		int[] original = createQueue(); //create 101 element array
		enqueue(original, 9); // enqueue 9
		enqueue(original, 8); // enqueue 8
		enqueue(original, 7); // enqueue 7
		enqueue(original, 6); // enqueue 6
		enqueue(original, 5); // enqueue 5
		enqueue(original, 4); // enqueue 4
		enqueue(original, 3); // enqueue 3
		dequeue(original); // dequeue
		dequeue(original); // dequeue
		dequeue(original); // dequeue
		enqueue(original, 1); // enqueue 1
		enqueue(original, 2); // enqueue 2
		enqueue(original, 3); // enqueue 3
		enqueue(original, 4); // enqueue 4
		dequeue(original); // dequeue
		dequeue(original); // dequeue
		dequeue(original); // dequeue
		dequeue(original); // dequeue
		dequeue(original); // dequeue
		System.out.println(prettyPrintQueue(original)); // print the final result
	} // end task5
	
	public static int[] merge(int[] a, int[] b) {
		int[] qA = createQueue(); // create new queue
		int[] qB = createQueue(); // create new queue
		int nextA; // initialize size of qA queue
		int nextB; // initialize size of qB queue
		for(int i = 0; i < a.length; i ++) { // runs through the length of array a
			qA[0] = a.length; // sets the first element in array to length
			qA[i + 1] = a[i]; // copies array
		}
		for(int i = 0; i < b.length; i ++) { //runs through the length of array b
			qB[0] = b.length; // sets the first element in array to length 
			qB[i + b.length] = b[i]; // copies array
		}
		int[] result = new int[a.length + b.length]; // create new array the size of the arrays a and b combined
		for(int i = 0; i < a.length; i++) { // run through the length of the a array
			result[i] = a[i]; // add it into the result array
		}
		for(int i = 0; i < b.length; i++) { // run through the length of the b array
			result[i + a.length - 1] = qB[i]; // add it into the result array
		}
		int t = 0; 
		for (int i = 0; i < result.length; i++) { // run through the length of the result array
			for( int j = i + 1; i < result.length; j++) { // sort through the array
				if(result[i] > result[j]) { // if the checked element is larger than the one following it, swap them
					t = result[i];
					result[i] = result[j];
					result[j] = t;
				}
			}
		}
		nextA = qA[0];
		nextB = qB[0];
		return result; // return the resulting array
	} // end merge
}
