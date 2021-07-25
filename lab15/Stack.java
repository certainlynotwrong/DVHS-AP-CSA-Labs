package lab15;

public class Stack {
	 private int[] storage;
	private int numberOfElements;
	
	
	public Stack() { // Constructors
		storage = new int[100]; // creates empty array of 100 elements
		numberOfElements = 0;
	}
	

	public static int[] copyArray(int[] a) { // start copyArray
		if(a == null) { // null check original array
			return null;
		} 
		int[] ret = new int[a.length]; // makes new array of identical length
		for(int i = 0; i < a.length; i++) { // traverses through original array
			ret[i] = a[i]; // copies all elements to same positions
			}
		return ret; // returns copied array
	} // end copyArray
	
	public static int[] append(int[] a, int[] b) { // start append
		if(a == null)
			return copyArray(b); // return other copied array
		if(b == null)
			return copyArray(a); // return other copied array
		int[] ret = new int[a.length + b.length]; // new array of combined length of originals
		for(int i = 0; i < a.length; i++) { // traverses first array
			ret[i] = a[i]; // copies all elements to the same positions
		}
		for(int i = 0; i < b.length; i++) { // traverses second array
			ret[i + a.length] = b[i];  // copies all elements to positions after first array's
		}
		return ret; // returns appended array
	} // end append
	
	public int[] getStorage() {
		return copyArray(storage);
	}
	
	public int getNumberOfElements() {
		return numberOfElements;
	}
	
	public void push(int a) { // start pop
		if(numberOfElements == storage.length) { // checks if there are array is filled
			int[] temp = new int[100];
			storage = append(storage, temp); // if so, increase size by 100
		}
		storage[numberOfElements] = a; // add element to end
		numberOfElements++; // increment number of elements
	} // end pop
	
	public int pop() { // start pop
		numberOfElements--; // decrement number of elements by 1
		return storage[numberOfElements]; // return last element
	} // end pop 
	
	public String toString() { // start toString
		String ret = "["; // initialize return string
        if(storage[0] == 0){
            return ret += "]";
        }
		ret += storage[0];
		for(int i = 1; i < numberOfElements; i++) { // traverse length of the array
			ret += ", " + storage[i];
		}
		ret += "]";
		return ret;
	} // end toString
	
	
	
		

	
	
	
	 
	
	
	
	
	
	

}
