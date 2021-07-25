package mrsdstuff;
import java.util.Arrays;
public class Assign8 {

	public static void main(String[] args) {
		int[] one = {69, 15, 30, 69, 420};
		System.out.println(arrayToString(one));
		int[][] two =  { {1, 2, 3},{3, 4, 5, 6},{7, 8, 9, 9} };
		System.out.println(Arrays.deepToString(two));
		System.out.println(arrayToString2D(two));
		int[][] tictac = { {-1, 1, -1}, {-1, 1, 1}, {1, -1, 1} };
		System.out.println(Arrays.deepToString(tictac));
		System.out.println(ticTacToeCheck(tictac));
		System.out.println(sum2D(two));
		int[][] major = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 1, 2}, {3, 4, 5, 6} };
		int[][] m3 = { {1, 2, 4}, {5, 6, 7, 8, 69, 420}, {9, 5, 1, 2}, {3, 4, 5, 6} };
		System.out.println(sum2Dmajor(major));
		System.out.println(sum2Dminor(major));
		System.out.println(min1DB(one));
		System.out.println(min1DA(one));
		System.out.println(min2D(m3));
		int[][] m4 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		System.out.println(Arrays.deepToString(m4));
		System.out.println(Arrays.deepToString(rotate(m4)));
		int[][] m5 = { {1, 2, 3}, {4, 5, 6} };
		System.out.println(Arrays.deepToString(expand(m5)));
		twelve();
		System.out.println(Arrays.deepToString(pascalsTriangle(15)));
	}
	
	public static String arrayToString(int[] a) { // start arrayToString
		if(a == null) { // null check
			return "null";
		} else {
		String ret = "{"; // initialize return string
		for(int i = 0; i < a.length; i++) { // traverse through the length of the array
			ret += a[i]; // concatenate string
			if(i < a.length - 1) { // add a comma between each element in the string except the last one 
				ret += ", ";
			}
		}
		ret += "}"; // close string
		return ret; // return the string
		}
	} // end arrayToString
	
	public static String arrayToString2D(int[][] a) { // start arrayToString2D
		if(a == null) { // null check
			return "null";
		} else {
			String ret = "{"; // initialize return string
			for(int i = 0; i < a.length; i++) { // traverse through the length of the array
				ret += arrayToString(a[i]); // concatenate string
				if(i < a.length - 1) {
					ret += ", \n "; // add comma and enter between each element in string except for last one
				}
			}
			ret += "}"; // close string
			return ret; // return the string
		}
	} // end arrayToString2D
	
	public static boolean ticTacToeCheck(int[][] a) {
		if(a[0][0] == a[1][0] && a[1][0] == a[2][0] || a[0][1] == a[1][1] && a[1][1] == a[2][1]
				|| a[0][2] == a[1][2] && a[1][2] == a[2][2] || a[0][0] == a[0][1] && a[0][1] == a[0][2] 
				|| a[1][0] == a[1][1] && a[1][1] == a[1][2] || a[2][0] == a[2][1] && a[2][1] == a[2][2]
				|| a[0][0] == a[1][1] && a[1][1] == a[2][2] || a[0][2] == a[1][1] && a[1][1] == a[2][0]) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int sum2D(int[][] a) { // start sum2D
		int ret = 0; // initialize return integer
		for(int i = 0; i < a.length; i++) { // traverse through the length of the array
			for(int j = 0; j < a[i].length; j++) {
				ret = ret + a[i][j]; // add all the elements in array together
			}
		}
		return ret; //return sum
	} // end sum2D
	
	public static int sum2Dmajor(int[][] a) { // start sum2Dmajor
		int ret = 0; // initialize return integer
		for(int i = 0; i < a.length; i++) { // traverse through the length of the array
			ret = ret + a[i][i]; // add all the elements in the major together
		}
		return ret; // return sum
	} // end sum2Dmajor
	
	public static int sum2Dminor(int[][] a) { // start sum2Dminor
		int ret = 0; // initialize return integer
		for(int i = a.length - 1; i > -1; i--) { // traverse through length of array
			ret = ret + a[i][i]; // add all the elements in the minor together
		}
		return ret; // return sum
	} // end sum2Dminor
	
	public static int min1DA(int[] a) { // start min1DA
		if(a == null) { // null check
			return -1;
		} else {
			int min = a[0]; // set return initially equal to first element of array
			for(int i = 1; i < a.length; i++) { // traverse the length of the array
				if(min > a[i]) // if the first element is larger than the checked element
					min = a[i]; // replace with the checked element
			}
			return min; // return the minimum value
		}
	} // end min1DA
	
	public static int min2D(int[][] a) { // start min2D
		if(a == null) { // null check
			return -1; // return -1, because the array could contain 0
		} 
		int[] temp = new int[a.length]; // create array the length of the rows
		for(int i = 0; i < a.length; i++) { // traverse the length of the array
			temp[i] = min1DA(a[i]); // fill array with smallest element in each row
		}
		return min1DA(temp); // return the smallest element in the new array
	} // end min2D
	
	public static int min1DB(int[] a) { // start min1D
		if(a == null) { // null check
			return 0; // if null return 0
		} else {
			int t = 0; // initialize temporary integer
			for(int i = 0; i < a.length; i++) { // traverse through length of array 
				for(int j = i + 1; j < a.length; j++) { // traverse through the length of the array, but the next one
					if(a[i] > a[j]) { // if the first checked is larger than the second checked
						t = a[i]; // set that to the temporary integer
						a[i] = a[j]; // set the larger element to the position
						a[j] = t; // set the second element to the temporary to look for a larger option
					}
				}
			}
			return a[0]; // return the first element in the sorted array
		}
	} // end min1D
	
	public static int min2DB(int[][] a) { // start min2DB
		if(a == null) { // null check
			return -1;
		}
		int[] temp = new int[a.length]; // create array the length of the rows
		for(int i = 0; i < a.length; i++) { // traverse the length of the array
			temp[i] = min1DB(a[i]); // fill array with the smallest element in each row
		}
		return min1DB(temp); // return the smallest element in the new array
	} // end min2DB
	
	public static int[][] rotate(int[][] a) { // start rotate
		for(int i = 0; i < a.length; i++) { // traverse through the length of the array
			for(int j = i; j < a.length - i - 1; j++) { // traverse through the columns
				int t = a[i][j]; // initialize temporary array
				a[i][j] = a[a.length - j - 1][i]; // start the rotating 
				a[a.length - j - 1][i] = a[a.length - i - 1][a.length - j - 1];
				a[a.length - i - 1][a.length - j - 1] = a[j][a.length - i - 1];
				a[j][a.length - i - 1] = t;
				}
			}
		if(a.length % 2 == 0) { // checks if dimensions are even
			return a;
		} else { // if dimensions are odd
			a[(a.length / 2)][(a.length / 2)] = a[(a.length / 2)][(a.length / 2)]; // copy the middle element
			return a; // return final array
		}
	} // end rotate

	public static int[][] expand(int[][] a) { // start expand
		if(a == null) { // null check
			return null;
		}		
		int[][] rA = new int [a.length * 2][]; // initialize new array with rows double the original
		for(int r = 0; r < a.length; r++) { // traverse the rows of the array
			rA[r * 2] = new int [a[r].length * 2]; // double the copied elements
			rA[2 * r + 1] = new int[a[r].length * 2]; // for the second row
			for(int c = 0; c < a[r].length; c++) { // traverse the columns of the array
				rA[2 * r][2*c] = a[r][c]; // for first row
				rA[2 * r][2 * c + 1] = a[r][c]; // for second row
				rA[2 * r + 1][2 * c] = a[r][c]; // for third row
				rA[2 * r + 1][2 * c + 1] = a[r][c]; // for fourth row
				}
			}
		return rA;
		} // end expand
	
	public static void twelve() { // start task 12
		for(int i = 1; i <= 6; i++) { // begin the first pattern
			for(int j = 1; j < i; j++) { // traverse through the length
				System.out.print(j); // print out the rows and columns
			}
			System.out.println(""); // add a space between each line
		}
		System.out.println(""); // add space between next pattern
		for(int i = 5; i >= 0; i--) { // begin second pattern
			for(int j = i; j > 0; j--) { // traverse, but decrement through the length
				System.out.print(j); // print rows and columns
			}
			System.out.println(""); // add space between each line 
		}
		System.out.println(""); // add space between next pattern
		for(int i = 1; i <= 6; i++) { // begin third pattern
			for(int j = 1; j < i; j++) { // traverse through the length
				System.out.print(6 - i +1); // print out the rows and columns 
			}
			System.out.println(""); // add space between each line
		}
	} // end task 12
	
	public static int[][] pascalsTriangle(int n) { // start pascalsTriangle
		int[][] ret = new int [n][]; // initialize return array
		for(int i = 0; i < ret.length; i++) { // traverse the length of the array
			ret[i] = new int[i + 1]; // create a new array for each row
			ret[i][0] = 1; // set the first element of each array to be 1
			ret[i][i] = 1; // set the last element of each array to be 1
			}
		for(int k = 0; k < ret.length; k++) { // traverse the length of the array
			for(int l = 0; l < ret[k].length; l++) { 
				if(k != 0) { // if at the edge elements
					if(l == 0 || l == ret[k].length - 1) {
						ret[k][l] = 1; // set edge element to 1
					} else {
						ret[k][l] = ret[k - 1][l] + ret[k-1][l-1]; // sum the top row's elements around desired element
					}
				}
			}
		}
		return ret; // return array
	} // end pascalsTriangle

}
