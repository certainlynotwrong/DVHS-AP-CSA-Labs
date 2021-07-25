package mrsdstuff;
import java.util.Scanner;
import java.util.Arrays;
public class Assign9 {

	public static void main(String[] args) {
		createMap(69, 420);
		print2D(createMapA());
		print2D(createMap(16));
		System.out.println(getSymbol(2));
		printMap(createMapA());
		System.out.println("");
		System.out.println(mapToString(createMapA()));
		System.out.println(Arrays.toString(find(createMapA(), 7)));
		System.out.println(minPath(createMapA()));
		
	}
	
	public static void print2D(int mat[][]) {
		for(int[] row: mat) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("");
	}
		
	public static int[][] createMap(int r, int c) { // start createMap
		int[][] ret = new int[r][c]; // create 2D array
		return ret; // return the array
	} // end createMap
	
	public static int[][] createMapA() { // start createMap
		int[][] ret = { {1, 3, 0, 0, 0, 0, 0, 0, 0, 0}, // arrays of every row
				{0, 3, 0, 3, 0, 3, 0, 3, 3, 0},
				{0, 0, 0, 3, 0, 0, 0, 3, 0, 0},
				{3, 0, 3, 0, 3, 3, 3, 0, 0, 3},
				{0, 0, 0, 0, 0, 0, 3, 0, 3, 0},
				{0, 3, 3, 3, 0, 0, 0, 3, 0, 0},
				{0, 0, 0, 0, 3, 3, 0, 0, 0, 3},
				{0, 3, 0, 0, 3, 0, 3, 0, 3, 0},
				{0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
				{0, 3, 0, 0, 3, 0, 0, 3, 0, 2} };
		return ret; // return the final array		
	} // end createMap
	
	public static int[][] createMap (int n) { // start createMap
		int[][] ret = new int[10][10]; // create 10x10 array
		for(int i = 0; i <= n; i ++) { // traverse how many walls are created
			ret[(int)(Math.random() * 10)][(int)(Math.random() * 10)] = 3; // insert walls in random positions
		}
		ret[0][0] = 1; // set starting position
		ret[9][9] = 2; // set ending position
		return ret; // return array
	} // end createMap
	
	public static String getSymbol(int value) { // start getSymbol
		String fin = ""; // initialize return string
		if(value == 0) {
			fin += "_"; // concatenate value to string
		} else if(value == 1) {
			fin += "Y"; // concatenate value to string
		} else if(value == 2) {
			fin += "F"; // concatenate value to string
		} else if(value == 3) {
			fin += "*"; // concatenate value to string
		}
		return fin; // return return string
	} // end getSymbol
	
	public static void printMap(int[][] m) { // start printMap
		int[][] ret = m; // copy the original array
		for (int r = 0; r < ret.length; r++) { // traverse length of the rows
			for (int c = 0; c < ret[r].length; c++) { // traverse columns
				System.out.print(getSymbol(ret[r][c]) + "  "); // print the element at position with two spaces
				}
			System.out.println(); // add space between each row
			}
	} // end printMap
	
	public static String mapToString(int[][] m) { // start mapToString
		String retur = ""; // initialize return string
		for(int i = 0; i < m.length; i++) {  // traverse length of the rows
			for(int j = 0; j < m[i].length; j++) { // traverse columns
				retur += getSymbol(m[i][j]) + "  "; // concatenate the converted elements and a 2 spaces
			}
			retur += "\n"; // add a new line between each column
		}
		return retur; // return the string
	} // end mapToString

	public static int[] find(int[][] m, int value) { // start find
		int[] ret = new int[2]; // initialize return array of length 2
		for(int i = 0; i < m.length; i++) { // traverse the length of the array
			for(int j = 0; j < m[i].length; j++) { // traverse columns
				if(m[i][j] == value) { // check if the value is equal to the position
					ret[0] = i; // set positions
					ret[1] = j;
					return ret; // return position
				}
			}
		}
		return null; // if value cannot be found, return null
	} // end find
	
	public static boolean canGoN (int[][] m) { // start canGoN
		int[] pos = find(m, 1); // find current position
		if((pos[0] == 0) || m[pos[0] - 1][pos[1]] == 3) { // if at top or there is wall above
			return false; 
		} else {
			return true;
		}
	} // end canGoN
	
	public static boolean canGoS (int[][] m) { // start canGoS
		int[] pos = find(m, 1); // find current position
		if((pos[0] == m.length - 1) || m[pos[0] + 1][pos[1]] == 3) { // if at bottom or this is wall below
			return false;
		} else {
			return true;
		}
	} // end canGoS
	
	public static boolean canGoE(int[][] m) { // start canGoE
		int[] pos = find(m, 1); // find current position
		if((pos[1] == m[0].length - 1) || m[pos[0]][pos[1] + 1] == 3) { // if at very right or there is wall to the right
			return false;
		} else {
			return true;
		}
	} // end canGoE
	
	public static boolean canGoW(int[][] m) { // start canGoW
		int[] pos = find(m, 1); // find current position
		if((pos[1] == 0) || m[pos[0]][pos[1] - 1] == 3) { // if at very left or there is wall to the left
			return false;
		} else {
			return true;
		}
	} // end canGoW
	
	public static String minPath(int[][] m){

		      String path = ""; // initialize recursive path variable
		      String actualpath = "null"; // initialize the best path variable

		      int[] myCoodinates = find(m,1);
		      int r = myCoodinates[0];
		      int c = myCoodinates[1];
		      
		      //Check if next to finish, if not set actualpath to first found path
		    if(actualpath == "null") {
		    	if(canGoS(m) && m[r+1][c] == 2)
		    		actualpath = path + "D";
		    	if(canGoN(m) && m[r-1][c] == 2)
		    		actualpath = path + "U";
		    	if(canGoE(m) && m[r][c+1] == 2)
		    		actualpath = path + "R";
		    	if(canGoW(m) && m[r][c-1] == 2)
		    		actualpath = path + "L";
		    } else { // compare path and actualpath. if path is shorter than actualpath, set actualpath equal to the new found path
		    

		    if(canGoS(m) && m[r+1][c] == 2)
		      return path + "D";
		    if(canGoN(m) && m[r-1][c] == 2)
		     return path + "U";
		    if(canGoE(m) && m[r][c+1] == 2)
		     return path + "R";
		    if(canGoW(m) && m[r][c-1] == 2)
		     return path + "L";
 // check directions 
		    // Down
		   if(canGoS(m)){
		     m[r][c] = 3;
		     m[r + 1][c] = 1;
		     path = minPath(m);
		     if (path != null)
		       return "D" + path;
		     m[r][c] = 1;
		     m[r+1][c] = 0;
		   }
		 
		   // Right
		   if(canGoE(m)){
		       m[r][c] = 3;
		       m[r][c+1] = 1;
		       path = minPath(m);
		       if(path != null)
		           return "R" + path;
		       m[r][c] = 1;
		       m[r][c+1] = 0;
		   }
		   // Left
		   if(canGoW(m)) {
		       m[r][c] = 3;
		       m[r][c - 1] = 1;
		       path = minPath(m);
		       if (path != null)
		           return "L" + path;
		       m[r][c] = 1;
		       m[r][c-1] = 0;
		   }
		   // Up
		   if(canGoN(m)) {
		       m[r][c] = 3;
		       m[r-1][c] = 1;
		       path = minPath(m);
		       if (path != null)
		           return "U" + path;
		       m[r][c] = 1;
		       m[r-1][c] = 0;
		   }
	}
 // returns best possible path
		   if(actualpath == "null")
			   return null;
		   else
			   return actualpath;
	}



	
	public static int[][][] create3dMap(int r, int c, int numFloors) { // start create3dMap
		int[][][] ret = new int[r][c][numFloors]; // create new array with set dimensions
		return ret; // return the array 
	} // end create3dmap
	
	public static int[][][] create3DMapA() { // start create3DMap
		  int[][][] rv = { // create the map
				  {
						  {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}, 
				  {			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 3, 3, 3}, 
				  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 3, 0, 0, 0, 0, 0, 3, 3, 3},
				  			  {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 3, 3, 3, 3, 3, 0, 3, 0, 0, 0, 0, 0, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 3, 0, 3, 3, 3, 0, 3, 0, 0, 0, 0, 0, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 3, 0, 3, 3, 3, 0, 3, 0, 0, 0, 0, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 0, 0, 3, 0, 3, 0, 3, 0, 0, 0, 0, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 3, 0, 3, 4, 3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 3, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 3, 0, 3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 3, 0, 3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 3, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0, 5, 3, 3, 3}, 
				  			  {3, 3, 3, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
				  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}}, 
					  {
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 0, 0, 4, 0, 4, 0, 0, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 0, 0, 4, 0, 4, 0, 0, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
								  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}}, 
					  {
					  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 
		  			  {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
							}
					};
		  return rv; // return final array
	} // end create3DMap
	
	public static int[][][] create3DMap(int numFloors) { // start create3DMap
		int[][][] ret = create3dMap(5, 5, numFloors); // initialize return array
		ret[0][0][0] = 1; // set starting position to 0, 0, 0
		for(int i = 0; i < numFloors; i++) { // traverse length of specified amount
			int j = (int)(Math.random()*4); // create random numbers 
			int k = (int)(Math.random()*4);
			ret[i][j][k] = 4; // build random
			ret[i + 1][j][k] = 5;
		}
		return ret;
	} // end create3DMap
	
	public static boolean canGoU(int[][][] map) { // start canGoU
		int[] pos = new int[2]; // initializes position array 
		for(int i = 0; i < map[0][0].length; i++) { //traverse through the array
			pos = find(map[i], 1); // set the position array to position
			if(pos != null) { // if position exists
				if(i == map[0][0].length - 1) // check if at top
					return false;
				else {
					if(map[pos[0]][pos[1]][i+1] != 3) // check if there is a wall above
						return true;
					else
						return false;

				}
			}
			else
				return false;
		}
		return false;
	} // end canGoU
	
	public static boolean canGoD(int[][][] map) { // start canGoD
		int[] pos = new int[2]; // initializes position array 
		for(int i = 0; i < map[0][0].length; i++) { //traverse through the array
			pos = find(map[i], 1); // set the position array to position
			if(pos != null) { // if position exists
				if(i == 0) // check if at bottom
					return false;
				else {
					if(map[pos[0]][pos[1]][i-1] != 3) // check if there is a wall below
						return true;
					else
						return false;

				}
			}
			else
				return false;
		}
		return false;
	} // end canGoD
	
	public static String mapToString(int[][][] m) { // start mapToString
		String ret = ""; // initialize return string
		for(int i = 0; i < m.length; i++) { // traverse the length of the array
			ret += "Level " + (i + 1) + ": \n"; // concatenate the level number and new line
			ret += mapToString(m[i]); // concatenate the actual maze
			if(i != 0) // if not at beginning
				ret += "\n"; // add new line after
		}
		return ret; // return the string
	} // end mapToString
	


}
