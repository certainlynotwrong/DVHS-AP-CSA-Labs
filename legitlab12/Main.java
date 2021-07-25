package legitlab12;

public class Main {

	public static void main(String[] args) {
		Date t1 = new Date(6, 25, 2004);
		System.out.println(Date.monthName(t1));
		System.out.println(Date.dateToString(t1));
		
		Date collin = new Date(3, 4, 2003);
		System.out.println("Your birthday is:");
		System.out.println(Date.dateToString(collin));
		
		
		Date today = new Date(12, 4, 2020);
		System.out.println(daysBetween(collin, today));
		System.out.println("****");
		System.out.println(daysBetweenarnav(collin, today));
		
		Date d1 = new Date(2, 5, 2020);
		Date d2 = new Date(1, 5, 2021);
		System.out.println(daysBetween(d1, d2));
		
		Date d3 = new Date(1, 5, 2020);
		Date d4 = new Date(10, 2, 2020);
		System.out.println(daysBetween(d3, d4));
		
		Date d5 = new Date(7, 14, 2012);
		System.out.println(daysBetween(d5, today));
		
		
		
		System.out.println("You are " + daysBetween(collin, today) * 1440 + " minutes old.");
		
	}
	
	public static boolean isLeapYear(Date d) { // start isLeapYear
		if(d.year % 4 == 0) { // check if year is divisible by 4
			if(d.year % 100 == 0) { // if so check if divisible by 100
				if(d.year % 400 == 0) { // if so check if divisible by 400
					return true; // if all criteria met it is a leap year
				} else {
					return false; // if it is divisible by 4 and 100 but not by 400 it is not leap year
				}
			} else {
				return true; // if it is divisible by 4 but not by 100 it is a leap year
			}
		} else {
			return false; // else it is not a leap year
		}
	} // end isLeapYear
	
	public static int daysBetween(Date d1, Date d2) {
		int ret = 0; // initialize return integer
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // array of days in normal year
		int[] daysInMonthL = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // array of days in leap year
		
		if((d1.year != d2.year && d1.month != d2.month) || (d1.year == d2.year && d1.month != d2.month)) {
			// if both month and years differ
			int df = 0; // initialize number of days in the first month
			if(isLeapYear(d1) == true) {
				df = daysInMonthL[d1.month - 1]; // set it equal to how many there are
			} else {
				df = daysInMonthL[d1.month];
			}
			ret += (df - d1.day); // add how many days left in the month
			
			if(d1.year == d2.year) { // if the years are the same, find difference between months
				for(int i = d1.month; i < d2.month - 1; i++) {
					if(isLeapYear(d1) == true) {
						ret += daysInMonthL[i];
					} else {
						ret += daysInMonth[i];
					}
				}
			}
			
			if(d1.year != d2.year) { // if years different, count remaining days
				for(int i = d1.month; i < 12; i++) {
					if(isLeapYear(d1) == true) {
						ret += daysInMonthL[i];
					} else {
						ret += daysInMonth[i];
					}
				}
			}
			for(int i = d1.year + 1; i < d2.year; i++) { // if years different, count days between
				ret += 365;
				if(i % 4 == 0 && i % 100 !=0)
					ret +=1;
				else if(i % 400 == 0)
					ret += 1;
			}
			if(d1.year != d2.year) { // if years different, days last year except for final month
				for(int i = 0; i < d2.month - 1; i++) {
					if(isLeapYear(d2) == true)
						ret += daysInMonthL[i];
					else
						ret += daysInMonth[i];
				}
			}
			ret += d2.day; // add days in the final month
		}
		if(d1.year == d2.year && d1.month == d2.month) { // if both months and years same
			ret = d2.day - d1.day; 
		}
		return ret; // return result
	}
	
	
	public static int daysBetweenarnav(Date d1, Date d2){
        int days = 0;
        int[] withoutLeap = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] withLeap = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        if((d1.year != d2.year && d1.month != d2.month) || (d1.year == d2.year && d1.month != d2.month)){
            int firstMonthDays = 0;
            if(isLeapYear(d1) == true){
                firstMonthDays = withLeap[d1.month];
            } else {
                firstMonthDays = withoutLeap[d1.month + 1];
            }
            days += (firstMonthDays - d1.day);
            if(d1.year == d2.year){
                for(int i = d1.month+1; i < d2.month; i++){
                    if(isLeapYear(d1) == true){
                        days += withLeap[i];
                    } else {
                        days += withoutLeap[i];
                    }
                }
            }
            if(d1.year!= d2.year){
                for(int i = d1.month+1; i < 13; i++){
                    if(isLeapYear(d1) == true){
                        days += withLeap[i];
                    } else {
                        days += withoutLeap[i];
                    }
                }
            }
                for(int j = d1.year+1; j<d2.year; j++){
                    days += 365;
                    if(j%4 == 0 || j%100 != 0){
                        days += 1;
                    } else if(j%400 == 0){
                        days += 1;
                    }
                }

            if(d1.year != d2.year){
                for(int k = 1; k < d2.month; k++){
                    if(isLeapYear(d2) == true){
                        days += withLeap[k];
                    } else {
                        days += withoutLeap[k];
                    }
                }
               
            }
            days += d2.day;
        }
        if(d1.year == d2.year && d1.month == d2.month){
            days = d2.day-d1.day;
        }
        return days;
    }

}
