package legitlab12;

public class Date {
	public int month, day, year;
	
	public Date() { // initialize instance variables
		month = 0;
		day = 0;
		year = 0;
	}
	
	public Date(int m, int d, int y) {
		this.month = m;
		this.day = d;
		this.year = y;
	}
	
	public static String monthName(Date d) { // start monthName
		String[] months = new String[] {"January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November",
				"December"}; // array of all months
		String ret = months[d.month - 1]; // add the month to the string
		return ret; // return the result
	}
	
	public static String dateToString(Date d) { // start dateToString
		String ret = ""; // initialize return string
		ret += monthName(d) + " " + d.day + ", " + d.year; // add month, day, and year
		return ret; // return resulting string
	} // end dateToString
	
}
