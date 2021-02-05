import java.time.Month;
import java.util.Calendar;
//mentions that we cannot add other data members..does that mean we cannot add
// the parameters in the isValid function?? stupid question
public class Date {
    private int year;
    private int month;
    private int day;

    public Date(String date) { //taking mm/dd/yyyy and create a Date object

        //Split the string from date variable in here
        String[] arrOfDate = date.split("/");

        //Assigning array of date to the first number(s) in 'mm' for 'mm/dd/yyyy' & Stripping the monthStr from any spaces so parseInt works.
        String monthStr = arrOfDate[0];
        monthStr = monthStr.strip();

        //Assigning the day, month, year -- turning the string into integer so the Date underneath can use it
        month = Integer.parseInt(monthStr);
        day = Integer.parseInt(arrOfDate[1]);
        year = Integer.parseInt(arrOfDate[2]);

        this.month = month;
        this.day = day;
        this.year = year;

        /*TESTING PURPOSES:
        System.out.println(month);
        System.out.println(day);
        System.out.println(year);
         */
    }

    public Date () // create object with today's date (see Calendar class)
    {
        //use the calendar class, getInstance() will give today's information
        Calendar today = Calendar.getInstance(); //gives instance of today's information

        this.day = today.DAY_OF_MONTH;
        this.month = today.MONTH;
        this.year = today.YEAR;

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isValid()
    //TODO CHECK THIS METHOD for functionality
    {
        boolean leap = false;
        int monthIncrement = 1;
        if(year < 1900 || year > 2021) {
            return false;
        }

        if(year % 4 == 0) { //step 1
            if(year %100 == 0) { //step 2
                if(year % 400 == 0) { //step 3
                    leap = true; //step 4
                }else {
                    leap = false; //step 5
                }
            }else {
                leap = true; //step 4
            }
        }else {
            leap = false; // step5
        }


        //we can use our own algo here
        switch(month) {

            case Calendar.JANUARY+1:
                if ( day < 1 || day > 31 ) {
                    return false;
                }
                break;
            case Calendar.FEBRUARY+1:
                if(leap) {
                    if(day <1 || day > 29) {
                        return false;
                    }
                }else if(day < 1 || day > 28) {
                    return false;
                }

                break;
            case Calendar.MARCH+1:
                if(day <1 || day > 31) {
                    return false;
                }
                break;
            case Calendar.APRIL+1:
                if(day <1 || day > 30) {
                    return false;
                }
                break;

            case Calendar.MAY+1:
                if(day <1 || day > 31) {
                    return false;
                }
                break;

            case Calendar.JUNE+1:
                if(day <1 || day > 30) {
                    return false;
                }
                break;

            case Calendar.JULY+1:
                if(day <1 || day > 31) {
                    return false;
                }
                break;

            case Calendar.AUGUST+1:
                if(day <1 || day > 31) {
                    return false;
                }
                break;

            case Calendar.SEPTEMBER+1:
                if(day <1 || day > 30) {
                    return false;
                }
                break;

            case Calendar.OCTOBER+1:
                if(day <1 || day > 31) {
                    return false;
                }
                break;

            case Calendar.NOVEMBER+1:
                if(day <1 || day > 30) {
                    return false;
                }
                break;
            case Calendar.DECEMBER+1:
                if(day <1 || day > 31) {
                    return false;
                }
                break;

            default:
                return false;

        }


        return true;
    }
}



/**
 * recitation notes: 2/1/21
 * the date has two constructors
 *
 * 1) transform the strings into integers
 * 2) you assign an input
 *
 * we can use getDate() or getTime() from Calendar class
 *
 * String date may have a lot of invalid inputs
 * checking constructor if it is a valid date for input
 * you need the date for the library and book class
 *
 * the date object itself
 * professor is going to test isValid() the most because that is the only one she is choosing to check for testing
 *
 * you can use system.out.print in the testbed
 * instead of using system.out you can also use the boolean values
 *
 *StdRandom.uniform(SUITES.length)
 *
 *
 */

