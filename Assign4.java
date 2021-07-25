package mrsdstuff;
public class Assign4 {

	public static void main(String[] args) {
		String s = "Hello world aAaA";
		String letter = "a";
		System.out.println(spaceCount(s));
		System.out.println(vowelCount(s));
		System.out.println(letterCount(s, letter));
		System.out.println(duplicate(s, letter));
		System.out.println(letterCount(s, letter));
		System.out.println(beforeString("Hello World", "World"));
		System.out.println(afterString("Hello World", "Wo"));
		System.out.println(capVowel("hello world"));
		System.out.println(capFirstWord("hello. my name is dave. goodbye."));
		System.out.println(isVowel("u"));
		System.out.println(reverse(s));

	}
	public static int spaceCount(String s) { //start spaceCount
		int cnt = 0; // initialize integer cou and set equal to 0
		char fintarg = ' '; // initialize character fintarg and set equal to a space
		for (int i = 0; i < s.length(); i++) { //goes through the length of the string
			if(s.charAt(i) == fintarg) // if the character matches in the string,
				cnt++; //increment the count by one
		}
		return cnt; // return the result of the count
	} //end spaceCount
	public static int vowelCount(String s) { //start vowelCount
		int cnt = 0; //initialize integer count and set equal to 0
		char choice1 = 'a'; // initialize the vowel characters
		char choice2 = 'e';
		char choice3 = 'i'; 
		char choice4 = 'o'; 
		char choice5 = 'u';
		char choice6 = 'A';
		char choice7 = 'E';
		char choice8 = 'I';
		char choice9 = 'O';
		char choice10 = 'U';
		for (int i = 0; i < s.length(); i++) { // goes through the length of the string
			char letter = s.charAt(i);
			if(letter == choice1 || letter == choice2 || letter == choice3 ||
			   letter == choice4 || letter == choice5 || letter == choice6 ||
			   letter == choice7 || letter == choice8 || letter == choice9 ||
			   letter == choice10) // if any of the characters match in the string
				cnt++; // increment the count by one
		}
		return cnt; // return the result of the count
	} //end vowel count
	public static int letterCount(String s, String letter) { // start letterCount
		String newlet = letter.toUpperCase(); // get the uppercase string of letter also
		int count = s.length() - s.replaceAll(letter, "").length(); /*subtract 
		the length of the string when all instances of the string letter is removed 
		from the length the original string */
		String repline = s.replaceAll(newlet,  ""); // set up a string with all the newlet's removed
		int newcount = s.length() - repline.length() + count; /*subtract the 
		length of the string when all instances of newlet removed from s from 
		the length of the string s, and then add count */
		return newcount; // return the result
	} // end letterCount
	
	public static String duplicate(String s, String letter) { // start duplicate
		int pos = s.indexOf(letter); // find the position of the 'letter' we need to duplicate
		char newlet = letter.charAt(0); // convert the letter to a character
		StringBuilder newstring = new StringBuilder(s); // set up newstring with a Stringbuilder class from the original string s 
		newstring.insert(pos, newlet); // insert the character at the defined position of the Stringbuilder, at pos
		return newstring.toString(); // convert the Stringbuilder back into a string and return the result
	} // end duplicate
	
	public static String letterCount(String s, String letter) { // start letterCount
		int count = 0; //initialize count and set equal to 0
		char original = letter.charAt(0); // convert the letter to a character
		char upperletter = Character.toUpperCase(original); // create a char of the letter in uppercase
		for (int i = 0; i < s.length(); i++) { // goes through the length of s
			if(s.charAt(i) == upperletter || s.charAt(i) == original) { // if the character at i is equal to the upper or lowercase letter,
				count++; //increment the count
			}
		}
		return count;	
	} // end letterCount
	
	public static String beforeString(String s, String substr) { // start beforeString
		int number = s.indexOf(substr); // find the index where the substr is located in s
		return s.substring(0, number); // return the string between the beginning of s and the index of the substr location
	} //end  beforeString
	
	public static String afterString(String s, String substr) { // start afterString
		int number = s.indexOf(substr); // find the index where the substr is located in s
		if (number != -1) // if the substr exists in the string
			return s.substring(number + 2, s.length()); // return the resulting string
		else
			return ""; // return a blank string if the substr does not exist in the string s
		} // end afterString
	
	public static String capVowel(String s) { // start capVowel
		char choice1 = 'a'; // define the lowercase characters
		char choice2 = 'e';
		char choice3 = 'i'; 
		char choice4 = 'o'; 
		char choice5 = 'u';
		char[] choicearr = s.toCharArray(); // convert the string s to a char array
		for (int i = 0; i < choicearr.length; i++) { // goes through the length of the array
			char letter = choicearr[i]; // sets letter equal to the character at i's location
			if(letter == choice1 || letter ==  choice2 || letter == choice3 ||
			   letter == choice4 || letter == choice5) { // if letter matches a lowercase vowel
				char upperletter = Character.toUpperCase(letter); //capitalize the lowercase vowel
				choicearr[i] = upperletter; // replace the lowercase letter in the string with its uppercase version
			}
		}
		return new String(choicearr); // return the capitalized string
	} // end capVowel
	
	public static String capFirstWord(String s) { // start capFirstWord
		String rS = ""; // initialize an empty string Rs
		for (int i = 0; i < s.length(); i++) { // goes through the length of the string s
			if (i == 0) { //on the first letter of the string
				rS += s.substring(i, i + 1).toUpperCase(); //capitalize the first letter in the range (0, 1)
			}
			else if(i > 1 && s.substring(i - 2, i).compareTo(". ") == 0) { // determine if the characters that follow are also right after a period and space
				rS += s.substring(i, i + 1).toUpperCase(); // if so then capitalize the letter in its specific range
			}
			else { // for all other characters
				rS +=s.substring(i, i + 1); // add the non capitalized characters to the rS string
			}
			}
		return rS; //returns the return string with all correct capitalized and lowercase characters
		} // end capFirstWord
	
	public static boolean isVowel(String s) { //start isVowel
		if (s == "a" || s == "e" || s == "i" || s == "o" || s == "u" || s == "A" //define the vowels in both lowercase and uppercase format
			|| s == "E" || s == "I" || s == "O" || s == "U") {
			return true; // if s is a vowel, then return true
		}
		else {
			return false; // if s is not a vowel, then return false
		}
	}  // end isVowel
	
	public static String reverse(String s) { // start reverse
		String rS = ""; // initialize an empty string rS
		for(int i = s.length() - 1; i > -1; i--) { // starting from the end of string s and working backwards by decrementing i each time the loop is run
			rS += s.substring(i, i + 1); // add the character to the string rS
		}
		return rS; // return the resulting backwards string
	} // end reverse
}
